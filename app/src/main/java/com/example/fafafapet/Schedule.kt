package com.example.fafafapet

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_schedule.*
import java.text.SimpleDateFormat
import java.util.*

class Schedule : AppCompatActivity() {

    private var cal = Calendar.getInstance()

    private fun setMyTimeFormat() :String{
        val myFormat = "HH:mm"
        val sdf = SimpleDateFormat(myFormat)
        return sdf.format(cal.time)
    }

    
        }
        return timeListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)


        var mAlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val requestCode = 101
        var mPendingIntent: PendingIntent? = null
        var sendIntent: Intent? = null
        switch1.setOnCheckedChangeListener { buttonview, isChecked ->
            if (isChecked) {
                if (mPendingIntent != null) {
                    mAlarmManager.cancel(mPendingIntent)
                    mPendingIntent?.cancel()
                }
                var setAlarmTime = Calendar.getInstance()
                var time = textWaktu.text.split(":")
                setAlarmTime.set(Calendar.HOUR_OF_DAY, time[0].toInt())
                setAlarmTime.set(Calendar.MINUTE, time[1].toInt())
                setAlarmTime.set(Calendar.SECOND, 0)

                sendIntent = Intent(this, MyAlarmReceiver::class.java)
                mPendingIntent = PendingIntent.getBroadcast(this, requestCode, sendIntent!!, 0)
                mAlarmManager.set(
                    AlarmManager.RTC_WAKEUP,
                    setAlarmTime.timeInMillis,
                    mPendingIntent
                )
                Toast.makeText(this, "Pengingat di atur pada jam ${textWaktu.text}", Toast.LENGTH_SHORT).show()
            }else{
                if(mPendingIntent!=null){
                    mAlarmManager.cancel(mPendingIntent)
                    mPendingIntent?.cancel()
                    Toast.makeText(this,"Pengingat dibatalkan",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
        textWaktu.setOnClickListener { TimePickerDialog(
            this,myTimePicker(),
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            true
        ).show() }
    }

    fun JadwalKonsultasi(view: View) {}
}