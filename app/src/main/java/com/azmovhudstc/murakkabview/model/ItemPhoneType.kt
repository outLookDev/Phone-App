package com.azmovhudstc.murakkabview.model

class ItemPhoneType {
    var phoneType=""
    var listPhone = ArrayList<ItemPhone>()
constructor()
    constructor(phoneType: String, listPhone: ArrayList<ItemPhone>) {
        this.phoneType = phoneType
        this.listPhone = listPhone
    }

}