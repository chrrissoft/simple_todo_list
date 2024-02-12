package com.chrrissoft.simpletodolist.ads.android

import android.content.Context
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext
import kotlin.random.Random.Default.nextDouble
import kotlin.time.DurationUnit.HOURS
import kotlin.time.DurationUnit.MINUTES
import kotlin.time.toDuration
import kotlin.time.toJavaDuration

class ShowAdWorker(
    appContext: Context,
    params: WorkerParameters,
    private val manager: ShowAdManager,
) : CoroutineWorker(appContext = appContext, params = params) {
    override suspend fun doWork(): Result {
        withContext(Main) { manager.load() }
        return Result.success()
    }


    companion object {
        const val SHOW_ADS_WORK_NAME = "com.chrrissoft.simpletodolist.SHOW_ADS"

        private val loadTimeRange
            get() = (nextDouble(from = 1.6, until = 2.4)).toDuration(HOURS)

        fun request() = PeriodicWorkRequestBuilder<ShowAdWorker>(loadTimeRange.toJavaDuration())
            .setBackoffCriteria(BackoffPolicy.LINEAR, (1).toDuration(MINUTES).toJavaDuration())
            .setConstraints(Constraints(NetworkType.CONNECTED, requiresBatteryNotLow = true))
    }
}
