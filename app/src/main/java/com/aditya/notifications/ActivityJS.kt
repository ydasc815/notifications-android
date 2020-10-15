package com.aditya.notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aditya.notifications.databinding.ActivityJSBinding

class ActivityJS : AppCompatActivity() {
    private lateinit var binding : ActivityJSBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_j_s)
    }
    private fun scheduleJob() {

    }
    private fun cancelJob() {

    }
}