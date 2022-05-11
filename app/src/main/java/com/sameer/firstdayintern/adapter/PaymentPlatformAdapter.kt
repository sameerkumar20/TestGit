package com.sameer.firstdayintern.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.sameer.firstday.adapter.ChildAdapter
import com.sameer.firstdayintern.R
import com.sameer.firstdayintern.model.OrderDetail

class PaymentPlatformAdapter(val context : Context, val mList: List<String>) :  RecyclerView.Adapter<PaymentPlatformAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.payment_chip_card, parent, false)

        return PaymentPlatformAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position],position)
    }

    override fun getItemCount(): Int {
      return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val pay_type : TextView = itemView.findViewById(R.id.payment_type)

        fun bind(data: String, position: Int) {
            pay_type.text = data
        }
    }
}