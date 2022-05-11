package com.sameer.firstdayintern.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sameer.firstdayintern.PaymentDeligate
import com.sameer.firstdayintern.R

class PaymentPlatformAdapter(val context : Context, val mList: List<String>,val paymentDeligate: PaymentDeligate) :  RecyclerView.Adapter<PaymentPlatformAdapter.ViewHolder>() {

   private var select_chip :Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.payment_chip_card, parent, false)

        return ViewHolder(view,paymentDeligate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position],position)
    }

    override fun getItemCount(): Int {
      return mList.size
    }

   inner class ViewHolder(itemView: View,val paymentDeligate: PaymentDeligate) : RecyclerView.ViewHolder(itemView) {
    val pay_type : TextView = itemView.findViewById(R.id.payment_type)


        fun bind(data: String, position: Int) {
            pay_type.text = data

            itemView.setOnClickListener {
                select_chip = adapterPosition
                paymentDeligate.onTapItem(data,adapterPosition)
                notifyDataSetChanged()
            }

            if (select_chip== adapterPosition){
               // pay_type.setBackgroundResource(R.drawable.selected_chips)
                itemView.background = ContextCompat.getDrawable(itemView.context,
                    R.drawable.selected_chips)
            }
            else{
                itemView.background = ContextCompat.getDrawable(itemView.context,
                R.drawable.chip)
            }


        }


    }
}