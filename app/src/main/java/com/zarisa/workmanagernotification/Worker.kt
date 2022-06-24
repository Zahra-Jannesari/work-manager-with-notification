package com.zarisa.workmanagernotification

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class Worker(private val ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        val builder = NotificationCompat.Builder(ctx, CHANNEL_ID)
            .setSmallIcon(R.drawable.notif_icon)
            .setContentTitle("Heads up notification")
            .setContentText("we missed you...:)")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(ctx)) {
            notify(NOTIF_ID, builder.build())
        }
        return Result.success()
    }
}