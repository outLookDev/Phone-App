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
import com.azmovhudstc.murakkabview.activitys.phone.PhoneAboutActivity
import com.azmovhudstc.murakkabview.model.Item
import com.azmovhudstc.murakkabview.model.ItemPhone
import com.azmovhudstc.murakkabview.model.ItemPhoneType
import com.azmovhudstc.murakkabview.utils.MyContact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecycleAdapterItem(private var list: ArrayList<ItemPhone>,private var activity: Activity):
    RecyclerView.Adapter<RecycleAdapterItem.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapterItem.ViewHolder {

        val v=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecycleAdapterItem.ViewHolder, position: Int) {

        if (list.isEmpty()){
            Toast.makeText(activity,"List bo`sh",Toast.LENGTH_SHORT).show()
        }
        else{
            var currentItem=list[position]

            holder.text.text=currentItem.phoneName
            holder.itemView.setOnClickListener {
                var intent =Intent(activity.applicationContext, PhoneAboutActivity::class.java)
                intent.putExtra("phoneNameOne",currentItem.phoneName)
                intent.putExtra("phoneFeaturesOne",currentItem.phoneFeatures)
                intent.putExtra("phoneTypeOne",currentItem.phoneType)
                intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
                activity.applicationContext.startActivity(intent)
                activity.finish()
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