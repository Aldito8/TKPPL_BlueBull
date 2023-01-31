package com.example.mysqlite

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pet : Parcelable{
    var id : Int = 0
    var nama : String = ""
    var no_hp : String = ""
    var weight : String = ""
}