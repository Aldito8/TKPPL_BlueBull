package com.example.fafafapet

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class MyConnectionReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(Settings.System.getInt(context.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON, 0) == 0){
            Toast.makeText(context, "Mode Pesawat : OFF", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Mode Pesawat : ON", Toast.LENGTH_SHORT).show()
        }
    }
}