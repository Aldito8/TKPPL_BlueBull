package com.example.fafafapet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_detail_doctor.*
import kotlinx.android.synthetic.main.list_item_view_doctor.*

class DetailDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doctor)

        var modalItems: DoctorItem = intent.getSerializableExtra("data") as DoctorItem;

    }

    fun TanyaDokter(view: View) {
        var intentChat = Intent(this, ChatActivity::class.java)
        startActivity(intentChat)
    }


}