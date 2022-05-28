package com.azmovhudstc.murakkabview.activitys.phone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azmovhudstc.murakkabview.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        add_phone.setOnClickListener{
            var intent =Intent(this,ChooseTypePhones::class.java)
            startActivity(intent)
        }
        phones.setOnClickListener {
            var intent =Intent(this,PhoneListChooseActivity::class.java)
            startActivity(intent)
        }
    }
}