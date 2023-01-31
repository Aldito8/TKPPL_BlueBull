package com.example.fafafapet

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_account.*

lateinit var preferences: SharedPreferences

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        btnKeluar.setOnClickListener{
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            var intentReply = Intent(this, LoginActivity::class.java)
            startActivity(intentReply)
            finish()
        }
    }

    fun DetailAkun(view: View) {}
}