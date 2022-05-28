package com.azmovhudstc.murakkabview.adapter


import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.azmovhudstc.murakkabview.R
import com.azmovhudstc.murakkabview.activitys.phone.PhoneItemActivity
import com.azmovhudstc.murakkabview.model.ItemPhoneType

class RecycleAdapterList(private var list: ArrayList<ItemPhoneType>,private var activity: Activity):
    RecyclerView.Adapter<RecycleAdapterList.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapterList.ViewHolder {

        val v=LayoutInflater.from(parent.context).inflate(R.layout.item_phone,parent,false)
        return ViewHolder(v)
    }



    override fun getItemCount(): Int {
        return list.size
    }
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var text:TextView = itemView.findViewById(R.id.type_ss)



    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (list.isEmpty()){
            Toast.makeText(activity,"List bo`sh",Toast.LENGTH_SHORT).show()

        }
        else{
            var currentItem=list[position]     

            holder.text.text=currentItem.phoneType
            holder.itemView.setOnClickListener {
                var intent=Intent(activity, PhoneItemActivity::class.java)
                intent.putExtra("ss",currentItem.phoneType)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                activity.applicationContext.startActivity(intent)
                activity. finish()

            }
        }
    }


}