package com.sameer.firstdayintern

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*

class SearchActivity : AppCompatActivity() {

    private var mId: Int?= null
    private var mTime: String? = null
    private var mPay: String? = null
    private var mPlatform: String? = null

    private lateinit var searchInput : EditText

    private lateinit var timeSpinner : Spinner
    private lateinit var paySpinner : Spinner
    private lateinit var platformSpinner : Spinner

    var timeList = listOf<String>("Today","This month","This Week","Yesterday")
    var paymentList = listOf<String>("Paid","Unpaid","Rejected")
    var platformList = listOf<String>("Cash","AyaPay","KBZ Pay","WavePay","KBZ Bank","Aya Bank","CB Bank","Yoma Bank")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        getIntentExtra()
        setUpSpinner()
    }

    private fun setUpSpinner(){

        searchInput = findViewById(R.id.id_search_input)
        timeSpinner = findViewById(R.id.sp_time)
        paySpinner = findViewById(R.id.sp_pay_type)
        platformSpinner = findViewById(R.id.sp_platform)

       // Toast.makeText(applicationContext,mId!!,Toast.LENGTH_LONG).show()
        searchInput.setText(mId!!.toString())

//        mId?.let { id->
//            searchInput.setText(id.toString())
//        }


        var timeAdapter : ArrayAdapter<String> = ArrayAdapter(applicationContext,android.R.layout.simple_dropdown_item_1line,timeList)
        timeSpinner.adapter = timeAdapter

        for(i in 0..timeList.size-1){
            if(mTime.equals(timeList[i]))
                timeSpinner.setSelection(i)
        }

        var payAdapter : ArrayAdapter<String> = ArrayAdapter(applicationContext,android.R.layout.simple_dropdown_item_1line,paymentList)
        paySpinner.adapter = payAdapter

        for(i in 0..paymentList.size-1){
            if(mPay.equals(paymentList[i]))
                paySpinner.setSelection(i)
        }


        var platformAdapter : ArrayAdapter<String> = ArrayAdapter(applicationContext,android.R.layout.simple_dropdown_item_1line,platformList)
        platformSpinner.adapter = platformAdapter

        for(i in 0..platformList.size-1){
            if(mPlatform.equals(platformList[i]))
                platformSpinner.setSelection(i)
        }

    }

    private fun getIntentExtra() {
        intent.getIntExtra(EXTRA_ID,0).let {
            mId = it
           // Toast.makeText(applicationContext,mId.toString(),Toast.LENGTH_LONG).show()
        }

        intent.getStringExtra(EXTRA_TIME).let{
            mTime = it
        }

        intent.getStringExtra(EXTRA_PAYMENT).let {
            mPay = it
        }

        intent.getStringExtra(EXTRA_PLATFORM).let{
            mPlatform = it
        }
    }

    companion object{

        const val EXTRA_ID = "extra id"
        const val EXTRA_TIME = "extra time"
        const val EXTRA_PAYMENT = "extra payment"
        const val EXTRA_PLATFORM = "extra platform"


        fun intent(context: Context,id: Int,time : String,payment_status : String,paid_platform : String): Intent{
            return Intent(context,SearchActivity::class.java).apply {
                putExtra(EXTRA_ID,id)
                putExtra(EXTRA_TIME,time)
                putExtra(EXTRA_PAYMENT,payment_status)
                putExtra(EXTRA_PLATFORM,paid_platform)
            }
        }
    }

}