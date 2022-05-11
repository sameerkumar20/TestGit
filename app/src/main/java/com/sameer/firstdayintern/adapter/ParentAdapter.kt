package com.sameer.firstday.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sameer.firstdayintern.R
import com.sameer.firstdayintern.model.Items
import com.sameer.firstdayintern.model.Order

class ParentAdapter(val context : Context, private val mList: List<Order>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_card, parent, false)

        return ViewHolder(view,context)
    }

    override fun onBindViewHolder(holder: ParentAdapter.ViewHolder, position: Int) {
         holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View,val context: Context) : RecyclerView.ViewHolder(ItemView) {

        val orders : TextView = ItemView.findViewById(R.id.id_orders)
        val recyclerView : RecyclerView = ItemView.findViewById(R.id.id_child_recycler)

           fun bind(data : Order){
               orders.text = data.qty.toString() + " orders"
               recyclerView.layoutManager = LinearLayoutManager(context)
               val childAdapter : ChildAdapter = ChildAdapter(context,data.orderDetails)
               recyclerView.adapter = childAdapter
           }
    }

}