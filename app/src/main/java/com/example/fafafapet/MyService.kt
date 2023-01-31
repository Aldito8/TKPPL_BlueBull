package com.example.fafafapet

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import java.lang.Exception

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this,"Latih Mulai", Toast.LENGTH_SHORT).show()
        Thread(Runnable {
            for (i in 0..10)
                try {
                    Thread.sleep(1000L)
                }
                catch (e: Exception){

                }
            stopSelf()
        }).start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Toast.makeText(this,"Latih Selesai", Toast.LENGTH_SHORT).show()
    }
}