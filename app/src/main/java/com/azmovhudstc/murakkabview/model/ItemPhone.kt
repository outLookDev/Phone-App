package com.azmovhudstc.murakkabview.model

import java.io.Serializable

class ItemPhone:Serializable {
    var phoneName=""
    var phoneFeatures=""
    var phoneType=""

    constructor()
    constructor(phoneName: String, phoneFeatures: String, phoneType: String) {
        this.phoneName = phoneName
        this.phoneFeatures = phoneFeatures
        this.phoneType = phoneType
    }
}
