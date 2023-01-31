package com.example.fafafapet

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_train_pet.*

class TrainPet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train_pet)

        var myService = Intent(this, MyService::class.java)
        btnStart.setOnClickListener{
            startService(myService)
        }
        btnBerhenti.setOnClickListener{
            stopService(myService)
        }
    }



    fun LihatLatih(view: View) {}

}