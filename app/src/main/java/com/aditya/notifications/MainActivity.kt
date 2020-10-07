package com.aditya.notifications

import android.app.Notification
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
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ONE)
            .setSmallIcon(R.drawable.notif_icon)
            .setContentTitle(binding.textOne.text.toString())
            .setContentText(binding.textTwo.text.toString())
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
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