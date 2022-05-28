package com.azmovhudstc.murakkabview.activitys.phone

import android.annotation.SuppressLint
import android.app.Activity
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.azmovhudstc.murakkabview.R
import com.azmovhudstc.murakkabview.adapter.RecycleAdapterItem
import com.azmovhudstc.murakkabview.model.Item
import com.azmovhudstc.murakkabview.model.ItemPhone
import com.azmovhudstc.murakkabview.utils.MyContact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.item_phone.*
import kotlinx.android.synthetic.main.phone_item_layout.*

class PhoneItemActivity:AppCompatActivity() {
    lateinit var gson: Gson
    private lateinit var list: ArrayList<ItemPhone>
    private lateinit var lists: ArrayList<ItemPhone>
    lateinit var adapter: RecycleAdapterItem

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phone_item_layout)
        view_list.layoutManager= LinearLayoutManager(this)
        val stringExtra = intent.getStringExtra("ss")
        lists= ArrayList()

        var isTrue=false
        for (i in 0 until loadData().size) {
            if (loadData()[i].phoneType==stringExtra){
                lists.add(
                    loadData()[i]
                )
                isTrue=true


            }
        }
        if (isTrue){
            adapter=RecycleAdapterItem(lists,this)
            view_list.adapter=adapter
            view_list.setHasFixedSize(true)
            toolbar_title.text=stringExtra
        }
        else{

            empty.visibility=View.VISIBLE
            toolbar_title.text="List Bo`sh "
        }

    }
    private fun loadData():ArrayList<ItemPhone>{

        MyContact.init(this)
        list= ArrayList()
        gson = Gson()

        var userstr = MyContact.user
        var type = object : TypeToken<ArrayList<ItemPhone>>() {}.type


        if (userstr?.isNotEmpty()==true){
            list = gson.fromJson(userstr, type)
        }
        for (i in 0 until list.size) {

        }
        return  list
    }
}




