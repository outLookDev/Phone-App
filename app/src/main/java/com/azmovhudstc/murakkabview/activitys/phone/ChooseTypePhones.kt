package com.azmovhudstc.murakkabview.activitys.phone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.azmovhudstc.murakkabview.R
import com.azmovhudstc.murakkabview.adapter.RecycleAdapter
import com.azmovhudstc.murakkabview.model.Item
import com.azmovhudstc.murakkabview.model.ItemPhone
import com.azmovhudstc.murakkabview.model.ItemPhoneType
import com.azmovhudstc.murakkabview.utils.MyContact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.choose_type.*

class ChooseTypePhones: AppCompatActivity() {
    lateinit var adapter: RecycleAdapter
    private lateinit var gson:Gson
    private lateinit var list1: ArrayList<ItemPhone>
    private lateinit var list: ArrayList<ItemPhoneType>
    private lateinit var listphone: ArrayList<ItemPhone>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_type)
        list_ss.layoutManager= LinearLayoutManager(this)
        list_ss.setHasFixedSize(true)
        adapter = RecycleAdapter(loadData(), this)

        list_ss.adapter=adapter
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

    private fun loadPhneData():ArrayList<ItemPhone>{

        MyContact.init(this)
        list1= ArrayList()
        gson = Gson()

        var userstr = MyContact.user
        var type = object : TypeToken<ArrayList<ItemPhone>>() {}.type


        if (userstr?.isNotEmpty()==true){
            list1 = gson.fromJson(userstr, type)
        }

        return  list1
    }

}
