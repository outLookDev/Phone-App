package com.azmovhudstc.murakkabview.activitys.phone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azmovhudstc.murakkabview.R
import kotlinx.android.synthetic.main.activity_phone_about.*

class PhoneAboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_about)
        val stringExtra = intent.getStringExtra("phoneNameOne")
        val stringExtra1 = intent.getStringExtra("phoneFeaturesOne")
        phone_name.text=stringExtra
        phone_featuress.text=stringExtra1


    }
}