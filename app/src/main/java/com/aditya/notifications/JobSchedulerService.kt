package com.aditya.notifications

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class JobSchedulerService : JobService() {
    override fun onStopJob(params: JobParameters?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        TODO("Not yet implemented")
    }

}