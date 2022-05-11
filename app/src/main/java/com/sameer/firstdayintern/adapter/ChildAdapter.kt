package com.sameer.firstday.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sameer.firstdayintern.R
import com.sameer.firstdayintern.model.OrderDetail

class ChildAdapter(val context : Context,val mList: List<OrderDetail>) : RecyclerView.Adapter<ChildAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.detail_card, parent, false)

        return ChildAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position],position)
    }

    override fun getItemCount(): Int {
      return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val order_id : TextView = ItemView.findViewById(R.id.id_orderid)
        val paid_type : TextView = ItemView.findViewById(R.id.id_paid_type)
        val name : TextView = ItemView.findViewById(R.id.id_name)
        val min : TextView = ItemView.findViewById(R.id.id_min)
        val pay_type :TextView = ItemView.findViewById(R.id.id_pay_type)
        val price :TextView = ItemView.findViewById(R.id.id_price2)
        val bar : FrameLayout = ItemView.findViewById(R.id.id_bar)

        @SuppressLint("ResourceAsColor")
        fun bind(data : OrderDetail, position: Int){

            order_id.text = "#" + data.id.toString()
            paid_type.text = "Paid." +data.paid_type
            name.text = "by " + data.name
            min.text = data.min.toString() + " min"
            pay_type.text = data.pay_type
            price.text = data.price.toString() + " Ks"

            if(position % 2 == 0){
                bar.setBackgroundColor(R.color.purple_200)
            }

        }
    }

}