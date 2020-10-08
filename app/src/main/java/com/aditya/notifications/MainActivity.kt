package com.aditya.notifications

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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

        val extraLargeIcon: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.notif_icon)

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ONE)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(binding.textOne.text.toString())
            .setContentText(binding.textTwo.text.toString())
            .setLargeIcon(extraLargeIcon)
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(extraLargeIcon)
                .bigLargeIcon(null))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
            .build()

        notificationManager.notify(1, notification)
    }

    private fun sendOnChannelTwo() {
        val extraLargeIcon: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.notif_icon)
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_TWO)
            .setSmallIcon(R.drawable.notif_icon)
            .setContentTitle(binding.textOne.text.toString())
            .setContentText(binding.textTwo.text.toString())
            .setLargeIcon(extraLargeIcon)
            .addAction(R.drawable.notif_icon, "Action 1", null)
            .addAction(R.drawable.notif_icon, "Action 2", null)
            .addAction(R.drawable.notif_icon, "Action 3", null)
            .setStyle(androidx.media.app.NotificationCompat.MediaStyle()
                .setShowActionsInCompactView(0, 1, 2))
            .setSubText("Sub Text")
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()

        notificationManager.notify(1, notification)
    }
}