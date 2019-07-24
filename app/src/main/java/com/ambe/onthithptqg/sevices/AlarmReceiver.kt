package com.ambe.onthithptqg.sevices

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.helper.Const
import java.util.*
import java.text.SimpleDateFormat


/**
 *  Created by AMBE on 23/7/2019 at 11:35 AM.
 */

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var time = intent?.getStringExtra(Const.TIME_ALARM)
        if (time!!.isNotEmpty()) {

            Log.e("AAAAAAA", time)
            setNotification(context, System.currentTimeMillis(), time)
        }
    }

    private fun setNotification(context: Context?, currentTimeMillis: Long, time: String?) {
        var manager = context?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = 0
        val channelId = "channel-01"
        val channelName = "Channel Name"
        val importance = NotificationManager.IMPORTANCE_HIGH

        var mBuilder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setColor(ContextCompat.getColor(context, R.color.colorWhite))
            .setContentTitle("Ôn Thi THPT")
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                channelId, channelName, importance
            )
            mChannel.lightColor = Color.GRAY
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            mChannel.enableVibration(true)
            manager.createNotificationChannel(mChannel)
        }
        mBuilder.setContentText("Đến giờ học rồi nào! Đừng có lười nữa...")
        mBuilder.setShowWhen(true)
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND)
        mBuilder.setAutoCancel(true)
        manager.notify(notificationId, mBuilder.build())


    }

    private var alarmMgr: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent

    fun setAlarm(context: Context, time: String) {
        alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = Intent(context, AlarmReceiver::class.java).putExtra(Const.TIME_ALARM, "aaaa")
            .let { intent ->
                PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            }

        val date12Format = SimpleDateFormat("hh:mm a")
        val d = SimpleDateFormat("yyyy/MM/dd hh:mm a")

        val date24Format = SimpleDateFormat("HH:mm")
        var time24 = date24Format.format(date12Format.parse(time))
        var now: Calendar = Calendar.getInstance()


        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = 0
            set(Calendar.HOUR_OF_DAY, time24.split(":")[0].toInt())
            set(Calendar.MINUTE, time24.split(":")[1].toInt())
            set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH))
            set(Calendar.MONTH, now.get(Calendar.MONTH))
            set(Calendar.YEAR, now.get(Calendar.YEAR))

        }


        Log.e("AAAAAAA", " vo day " + d.format(calendar.timeInMillis))
        Log.e("AAAAAAA", " vo day " + d.format(now.timeInMillis))

        if (calendar.before(now)) {

            Log.e("AAAAAAA", " vo day")

            calendar.add(Calendar.DAY_OF_MONTH, 1)

        }

        alarmMgr?.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )

    }


}