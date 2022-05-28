package com.azmovhudstc.murakkabview.activitys.phone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.azmovhudstc.murakkabview.R
import com.azmovhudstc.murakkabview.model.Item
import com.azmovhudstc.murakkabview.model.ItemPhone
import com.azmovhudstc.murakkabview.utils.MyContact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.musfickjamil.snackify.Snackify
import kotlinx.android.synthetic.main.activity_add_phone.*
import kotlin.math.log
import android.widget.Toast.makeText as makeText1

class AddPhoneActivity : AppCompatActivity() {
    lateinit var list: ArrayList<ItemPhone>
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone)
        MyContact.init(this)
        gson = Gson()
        list= ArrayList()
        var type = object : TypeToken<ArrayList<ItemPhone>>() {}.type

        save_phone.setOnClickListener{
            val toString = phone_name.text.trim().toString()
            val toString1 = phone_features.text.trim().toString()
            val stringExtra = intent.getStringExtra("phoneType")
            if (toString.isEmpty() && toString1.isEmpty()){
                makeText1(this, "Bo`sh maydonlarni to`ldiring", Toast.LENGTH_SHORT).show()

            }

            else{
                var item = ItemPhone(toString,toString1,stringExtra!!)
                if (MyContact.user!!.isNotEmpty()) {


                    list = gson.fromJson(MyContact.user, type)
                    list.add(item)
                } else {
                    list = ArrayList()

                    list.add(item)

                }
                val toJson = gson.toJson(list, type)
                MyContact.user = toJson.toString()

              //  Snackify.success(findViewById(android.R.id.content), "Success message !", Snackify.LENGTH_LONG).show()

                finish()
            }

        }
    }
}