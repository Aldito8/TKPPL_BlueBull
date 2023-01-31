package com.example.fafafapet

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import kotlinx.android.synthetic.main.activity_detail_doctor2.*
import java.text.SimpleDateFormat
import java.util.*

private var sp : SoundPool? = null
private var soundID = 0


class DetailDoctorActivity2 : AppCompatActivity() {

    val formatDate = SimpleDateFormat("dd MMMM YYYY")
    val formatTime = SimpleDateFormat("HH:mm")

    val CHANNEL_ID = "channel_id_01"
    val notificationId = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doctor2)

        textView_get_date.setOnClickListener(View.OnClickListener {
            val getDate = Calendar.getInstance()
            val datepicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, year)
                    selectDate.set(Calendar.MONTH, month)
                    selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val date = formatDate.format(selectDate.time)
                    textView_get_date.text = date

                }
            DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                datepicker, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH)).show()


        })

        textView_get_time.setOnClickListener(View.OnClickListener {
            val getTime = Calendar.getInstance()
            val timepicker = TimePickerDialog.OnTimeSetListener { timepicker, hour, minute ->
                    val selectTime = Calendar.getInstance()
                    selectTime.set(Calendar.HOUR_OF_DAY, hour)
                    selectTime.set(Calendar.MINUTE, minute)
                    val time = formatTime.format(selectTime.time)
                    textView_get_time.text = time
                }
            TimePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                timepicker, getTime.get(Calendar.HOUR_OF_DAY), getTime.get(Calendar.MINUTE), true).show()
        })
        createNotificationChannel()

        btn_appointment.setOnClickListener{
            sendNotification()
            if(soundID != 0){
                sp?.play(soundID, .99f, .99f, 1, 0, .99f)
            }
        }
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Notification Title"
            val descriptionText = "Notification description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager: NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun sendNotification(){
        val notifyDetailIntent = Intent(this@DetailDoctorActivity2,
            Schedule::class.java)

        val myPendingIntent = TaskStackBuilder.create(this)
            .addNextIntentWithParentStack(notifyDetailIntent)
            .getPendingIntent(110,PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.logoandroid)
            .setContentTitle("Konsultasi")
            .setContentText("Jadwal Konsultasi telah berhasil dibuat")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(myPendingIntent)
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)){
            notify(notificationId, builder.build())
        }
    }


    fun LihatDokter(view: View) {}


    override fun onStart() {
        super.onStart()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            createNewSoundPool()
        }
        else{
            createOldSoundPool()
        }
        soundID = sp?.load(this, R.raw.soundefek, 1) ?: 0
    }

    private fun createOldSoundPool() {
        sp = SoundPool(15, AudioManager.STREAM_MUSIC, 0)
    }

    private fun createNewSoundPool() {
        sp = SoundPool.Builder()
            .setMaxStreams(15)
            .build()
    }

    override fun onStop() {
        super.onStop()
        sp?.release()
        sp = null
    }
}