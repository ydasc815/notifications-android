package com.aditya.notifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.content.getSystemService

const val CHANNEL_ONE: String  = "channel1"
const val CHANNEL_TWO: String = "channel2"

class Notifications : Application() {
    /* Assigning ids to different notification channels */
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_ONE,
                "Channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "This is Notification Channel #1"

            val channel2 = NotificationChannel(
                CHANNEL_TWO,
                "Channel 2",
                NotificationManager.IMPORTANCE_LOW
            )
            channel2.description = "This is Notification Channel #2"

            val notificationManager: NotificationManager = getSystemService(NotificationManager::class.java)!!
            notificationManager.createNotificationChannel(channel1)
            notificationManager.createNotificationChannel(channel2)
        }
    }
}