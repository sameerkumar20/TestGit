package com.sameer.firstdayintern

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sameer.firstdayintern.adapter.PaymentPlatformAdapter

class filterActivity : AppCompatActivity(),PaymentDeligate {

    // post parameters
     var id : Int = 4
     var time : String = "Today"
     var payment_status = "Paid"
     var paid_platform = "Aya Bank"


    //Input
    lateinit var id_input : EditText
    //Input

    //Time

    lateinit var time_frame_click : FrameLayout
    lateinit var time_frame_hide : FrameLayout
    lateinit var rb1 : RadioButton
    lateinit var rb2 : RadioButton
    lateinit var rb3 : RadioButton
    lateinit var rb4 : RadioButton

    //Time

    //Payment

    lateinit var payment_frame_click : FrameLayout
    lateinit var payment_frame_hide : FrameLayout
    lateinit var paid : TextView
    lateinit var unpaid : TextView
    lateinit var reject : TextView

    //Payment

    //Platform

    var payList = mutableListOf<String>("Cash","AyaPay","KBZPay","WavePay","KBZ Bank","Aya Bank","CB Bank","Yoma Bank")
    lateinit var  platform_frame_click : FrameLayout
    lateinit var  platform_frame_hide : FrameLayout
    lateinit var  recyclerView: RecyclerView

    //Platform

    //Search
    lateinit var search : Button
    //Search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        // Time

        time_frame_click = findViewById(R.id.id_time_frame_click)
        time_frame_hide  = findViewById(R.id.id_time_frame_hide)
        rb1 = findViewById(R.id.id_rb1)
        rb2 = findViewById(R.id.id_rb2)
        rb3 = findViewById(R.id.id_rb3)
        rb4 = findViewById(R.id.id_rb4)

        //initialize radio button

        rb1.isChecked = true

        rb1.setOnClickListener {
            customRadioButtonOnClick(rb1)
        }

        rb2.setOnClickListener {
            customRadioButtonOnClick(rb2)
        }

        rb3.setOnClickListener {
            customRadioButtonOnClick(rb3)
        }

        rb4.setOnClickListener {
            customRadioButtonOnClick(rb4)
        }

        time_frame_click.setOnClickListener {
            showHide(time_frame_hide)
        }

        // Time

        // Payment

        payment_frame_click = findViewById(R.id.id_payment_frame_click)
        payment_frame_hide = findViewById(R.id.id_payment_frame_hide)
        paid = findViewById(R.id.id_payment_paid)
        unpaid = findViewById(R.id.id_payment_unpaid)
        reject = findViewById(R.id.id_payment_reject)

        paid.background = ContextCompat.getDrawable(applicationContext,R.drawable.selected_chips)

        payment_frame_click.setOnClickListener {
            showHide(payment_frame_hide)
        }

        paymentOnclickListeners()

        // Payment platform Recycler

        platform_frame_click = findViewById(R.id.id_platform_frame_click)
        platform_frame_hide = findViewById(R.id.id_platform_frame_hide)
        recyclerView = findViewById(R.id.id_payment_plaform_recycler)

        platform_frame_click.setOnClickListener {
            showHide(platform_frame_hide)
        }

        recyclerView.layoutManager = GridLayoutManager(this,4)
        val paymentPlatformAdapter : PaymentPlatformAdapter = PaymentPlatformAdapter(applicationContext,payList,this)
        recyclerView.adapter = paymentPlatformAdapter



        // Payment platform Recycler

        //Search

        search = findViewById(R.id.btnSearch)
        id_input = findViewById(R.id.id_filter_input)
        search.setOnClickListener {

          //  if(id_input.text.length == 0){
                id = id_input.text.toString().toInt()
               // Toast.makeText(applicationContext,id.toString(),Toast.LENGTH_LONG).show()
                startActivity(SearchActivity.intent(this,id,time,payment_status,paid_platform))
          //

        }
        //Search

    }

    private fun paymentOnclickListeners(){

        paid.setOnClickListener {
            paid.background = ContextCompat.getDrawable(applicationContext,R.drawable.selected_chips)
            unpaid.background = ContextCompat.getDrawable(applicationContext,R.drawable.chip)
            reject.background = ContextCompat.getDrawable(applicationContext,R.drawable.chip)
            payment_status = "Paid"
        }

        unpaid.setOnClickListener {
            paid.background = ContextCompat.getDrawable(applicationContext,R.drawable.chip)
            unpaid.background = ContextCompat.getDrawable(applicationContext,R.drawable.selected_chips)
            reject.background = ContextCompat.getDrawable(applicationContext,R.drawable.chip)
            payment_status = "Unpaid"
        }

        reject.setOnClickListener {
            paid.background = ContextCompat.getDrawable(applicationContext,R.drawable.chip)
            unpaid.background = ContextCompat.getDrawable(applicationContext,R.drawable.chip)
            reject.background = ContextCompat.getDrawable(applicationContext,R.drawable.selected_chips)
            payment_status = "Rejected"
        }


    }

    fun changeSelectedBackground(){
        rb1.isChecked = true
        paid.background = ContextCompat.getDrawable(applicationContext,R.drawable.selected_chips)

    }

    private fun customRadioButtonOnClick(radioButton: RadioButton) {
        when (radioButton) {
            rb1 ->  {
                rb1.isChecked = true
                rb2.isChecked = false
                rb3.isChecked = false
                rb4.isChecked = false
                time = rb1.text.toString()
            }
            rb2 -> {
                rb1.isChecked = false
                rb2.isChecked = true
                rb3.isChecked = false
                rb4.isChecked = false
                time = rb2.text.toString()
            }
            rb3 -> {
                rb1.isChecked = false
                rb2.isChecked = false
                rb3.isChecked = true
                rb4.isChecked = false
                time = rb3.text.toString()
            }
            rb4 -> {
                rb1.isChecked = false
                rb2.isChecked = false
                rb3.isChecked = false
                rb4.isChecked = true
                time = rb4.text.toString()
            }
        }
    }

    private fun showHide(view : View){
        if(view.visibility == View.VISIBLE)
            view.visibility = View.GONE
        else
            view.visibility = View.VISIBLE
    }

    override fun onTapItem(data: String,position : Int) {
           paid_platform = data
         Toast.makeText(applicationContext,data,Toast.LENGTH_SHORT).show()
    }

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, filterActivity::class.java)
        }
    }
}