package com.example.fafafapet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ShopItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
    }

    fun Beli(view: View) {
        var intentBuy = Intent(this, PaymentActivity::class.java)
        startActivity(intentBuy)
    }

    fun lihatLebih(view: View) {}
}