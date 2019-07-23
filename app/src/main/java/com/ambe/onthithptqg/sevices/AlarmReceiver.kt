package com.ambe.onthithptqg.sevices

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.support.v4.content.ContextCompat
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.helper.Const

/**
 *  Created by AMBE on 23/7/2019 at 11:35 AM.
 */

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent?.getBundleExtra(Const.ALARM_EXTRA)
        var time = bundle?.getString(Const.TIME_ALARM, "")
        if (time != "") {
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

        }

    }


}