package com.sameer.firstdayintern.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sameer.firstdayintern.R
import com.sameer.firstdayintern.model.Items

    class RecyclerAdapter(val context : Context, private val mList: List<Items>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card, parent, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val ItemsViewModel = mList[position]
            Glide.with(context)
                .load(ItemsViewModel.image_url)
                .into(holder.image);
            holder.title.text = ItemsViewModel.title
            holder.price.text = ItemsViewModel.price.toString() +"Ks / Month"

        }

        override fun getItemCount(): Int {
            return mList.size
        }

        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val image: ImageView = ItemView.findViewById(R.id.id_image)
            val title : TextView = ItemView.findViewById(R.id.id_title)
            val price : TextView = ItemView.findViewById(R.id.id_price)

        }
    }
