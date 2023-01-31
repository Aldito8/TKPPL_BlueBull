package com.example.fafafapet

import java.io.Serializable

class DoctorItem : Serializable{

    var icons:Int? = 0
    var name:String? = null
    var fields:String? = null
    var location:String? = null

    constructor(icons: Int?, name: String?, fields: String?, location: String?) {
        this.icons = icons
        this.name = name
        this.fields = fields
        this.location = location
    }
}