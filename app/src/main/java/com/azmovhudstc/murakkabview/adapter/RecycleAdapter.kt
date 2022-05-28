package com.azmovhudstc.murakkabview.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.azmovhudstc.murakkabview.R
import com.azmovhudstc.murakkabview.activitys.phone.AddPhoneActivity
import com.azmovhudstc.murakkabview.activitys.phone.ChooseTypePhones
import com.azmovhudstc.murakkabview.model.Item
import com.azmovhudstc.murakkabview.model.ItemPhoneType

class RecycleAdapter(private var list: ArrayList<ItemPhoneType>,private var activity: Activity):
    RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapter.ViewHolder {

        val v=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecycleAdapter.ViewHolder, position: Int) {

        if (list.isEmpty()){
            Toast.makeText(activity,"List bo`sh",Toast.LENGTH_SHORT).show()
        }
        else{
            var currentItem=list[position]

            holder.text.text=currentItem.phoneType
          holder.itemView.setOnClickListener {
             var intent=Intent(activity, AddPhoneActivity::class.java)
             intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
              intent.putExtra("phoneType",currentItem.phoneType)

              activity.applicationContext.startActivity(intent)
             activity. finish()

         }
        }
        }


    override fun getItemCount(): Int {
        return list.size
    }
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var text:TextView = itemView.findViewById(R.id.text1)



    }


}