package com.sameer.firstdayintern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    lateinit var first : Button
    lateinit var second : Button
    lateinit var filter : Button  // third Activity
    lateinit var fourth: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first = findViewById(R.id.id_first)
        second = findViewById(R.id.id_second)
        filter = findViewById(R.id.id_third)
        fourth = findViewById(R.id.id_fourth)

        first.setOnClickListener {
            startActivity(FirstActivity.newIntent(this))
        }

        second.setOnClickListener {
            startActivity(SecondActivity.newIntent(this)
            )
        }

        filter.setOnClickListener {
            startActivity(filterActivity.newIntent(this))
        }

        fourth.setOnClickListener {
            startActivity(MultiRecyclerView.newIntent(this))
        }

    }
}