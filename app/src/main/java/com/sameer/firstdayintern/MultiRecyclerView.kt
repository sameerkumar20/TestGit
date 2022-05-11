package com.sameer.firstdayintern

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sameer.firstday.adapter.ParentAdapter
import com.sameer.firstdayintern.model.Order
import com.sameer.firstdayintern.model.OrderDetail

class MultiRecyclerView : AppCompatActivity() {

    lateinit var parent_recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_recycler_view)

        parent_recycler = findViewById(R.id.parent_recycler)

        val data = ArrayList<Order>()
        val orderDetail = ArrayList<OrderDetail>()
        for (i in 1..2){
            for (j in 1..2){
                orderDetail.add(OrderDetail(2222,"UnPaid","sameer",1,"KBZ Pay",220000))
            }
            data.add(Order(1,orderDetail))
        }

        val parentAdapter = ParentAdapter(applicationContext,data)
        parent_recycler.layoutManager = LinearLayoutManager(this)
        parent_recycler.adapter = parentAdapter

    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MultiRecyclerView::class.java)
        }
    }
}