package com.aditya.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, intent?.getStringExtra("toastMessage"), Toast.LENGTH_LONG).show()
    }

}