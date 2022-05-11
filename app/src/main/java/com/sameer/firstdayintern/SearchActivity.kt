package com.sameer.firstdayintern

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SearchActivity : AppCompatActivity() {

    private var mId: Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        getIntentExtra()
        setUpData()
    }

    private fun setUpData() {
      //  val tvData = findViewById<TextView>(R.id.tvId)

        mId?.let { id->
           // tvData.text = id.toString()
        }
    }

    private fun getIntentExtra() {
        intent.getIntExtra(EXTRA_ID,0).let {
            mId = it
        }
    }

    companion object{

        const val EXTRA_ID="extra id"

        fun intent(context: Context,id: Int): Intent{
            return Intent(context,SearchActivity::class.java).apply {
                putExtra(EXTRA_ID,id)
            }
        }
    }

}