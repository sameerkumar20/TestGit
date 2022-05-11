package com.sameer.firstdayintern

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.RadioButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sameer.firstdayintern.adapter.PaymentPlatformAdapter

class filterActivity : AppCompatActivity() {

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

    //Payment

    //Platform

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

        payment_frame_click.setOnClickListener {
            showHide(payment_frame_hide)
        }

        // Payment platform Recycler

        platform_frame_click = findViewById(R.id.id_platform_frame_click)
        platform_frame_hide = findViewById(R.id.id_platform_frame_hide)
        recyclerView = findViewById(R.id.id_payment_plaform_recycler)

        platform_frame_click.setOnClickListener {
            showHide(platform_frame_hide)
        }

        var pay_list = listOf<String>("Cash","AyaPay","KBZPay","WavePay","KBZ Bank","Aya Bank","CB Bank","Yoma Bank")
        recyclerView.layoutManager = GridLayoutManager(this,4)
        val paymentPlatformAdapter : PaymentPlatformAdapter = PaymentPlatformAdapter(applicationContext,pay_list)

        recyclerView.adapter = paymentPlatformAdapter
        // Payment platform Recycler

        //Search

        search = findViewById(R.id.id_search)
        search.setOnClickListener {

        }
        //Search

    }

    private fun customRadioButtonOnClick(radioButton: RadioButton) {
        when (radioButton) {
            rb1 ->  {
                rb1.isChecked = true
                rb2.isChecked = false
                rb3.isChecked = false
                rb4.isChecked = false
            }
            rb2 -> {
                rb1.isChecked = false
                rb2.isChecked = true
                rb3.isChecked = false
                rb4.isChecked = false
            }
            rb3 -> {
                rb1.isChecked = false
                rb2.isChecked = false
                rb3.isChecked = true
                rb4.isChecked = false
            }
            rb4 -> {
                rb1.isChecked = false
                rb2.isChecked = false
                rb3.isChecked = false
                rb4.isChecked = true
            }
        }
    }

    private fun showHide(view : View){
        if(view.visibility == View.VISIBLE)
            view.visibility = View.GONE
        else
            view.visibility = View.VISIBLE
    }

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, filterActivity::class.java)
        }
    }
}