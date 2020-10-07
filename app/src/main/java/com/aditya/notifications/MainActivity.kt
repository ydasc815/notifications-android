package com.aditya.notifications

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import com.aditya.notifications.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var notificationManager: NotificationManagerCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        notificationManager = NotificationManagerCompat.from(this)
        binding.channelOneBtn.setOnClickListener { sendOnChannelOne() }
        binding.channelTwoBtn.setOnClickListener { sendOnChannelTwo() }
    }
    private fun sendOnChannelOne() {
        val activityIntent = Intent(this, MainActivity::class.java)
        val contentIntent: PendingIntent = PendingIntent.getActivity(this, 0, activityIntent, 0)

        val broadcastIntent = Intent(this, NotificationReceiver::class.java)
        broadcastIntent.putExtra("toastMessage", binding.textTwo.text.toString())
        val actionIntent: PendingIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent,
            PendingIntent.FLAG_UPDATE_CURRENT)
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ONE)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(binding.textOne.text.toString())
            .setContentText(binding.textTwo.text.toString())
            .setColor(Color.BLUE)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
            .build()

        notificationManager.notify(1, notification)
    }

    private fun sendOnChannelTwo() {
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_TWO)
            .setSmallIcon(R.drawable.notif_icon)
            .setContentTitle(binding.textOne.text.toString())
            .setContentText(binding.textTwo.text.toString())
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()

        notificationManager.notify(1, notification)
    }
}