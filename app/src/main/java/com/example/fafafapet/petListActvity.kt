package com.example.fafafapet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fafafapet.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_pet_list_actvity.*

class petListActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_list_actvity)

        btnKembali.setOnClickListener{
            onBackPressed()
        }
    }

    fun LihatPeliharaaan(view: View) {}
}