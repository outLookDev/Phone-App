package com.azmovhudstc.murakkabview.activitys.phone

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.azmovhudstc.murakkabview.R
import com.azmovhudstc.murakkabview.adapter.RecycleAdapterList
import com.azmovhudstc.murakkabview.model.ItemPhone
import com.azmovhudstc.murakkabview.model.ItemPhoneType
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_phone_list_choose.*

class PhoneListChooseActivity : AppCompatActivity() {
    lateinit var gson: Gson
    private lateinit var list: ArrayList<ItemPhoneType>
    private lateinit var listphone: ArrayList<ItemPhone>
    lateinit var adapter: RecycleAdapterList

    @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_phone_list_choose)
            sss.layoutManager=GridLayoutManager(this,2)
            sss.setHasFixedSize(true)


            adapter = RecycleAdapterList(loadData(),this)

        sss.adapter=adapter







        }
    private fun loadData():ArrayList<ItemPhoneType>{
        listphone= ArrayList()
        list= ArrayList()
        list.add(ItemPhoneType("iPhone",loadPhneData()))
        list.add(ItemPhoneType("Samsung",loadPhneData()))
        list.add(ItemPhoneType("Mi",loadPhneData()))
        list.add(ItemPhoneType("Sony",loadPhneData()))
        list.add(ItemPhoneType("Huawei",loadPhneData()))
        list.add(ItemPhoneType("Artel",loadPhneData()))

        return  list
    }
    private fun loadPhneData(): ArrayList<ItemPhone> {
        listphone= ArrayList()
        return listphone
    }

}