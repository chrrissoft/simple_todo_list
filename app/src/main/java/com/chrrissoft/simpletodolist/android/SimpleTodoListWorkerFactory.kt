package com.chrrissoft.simpletodolist.android

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.chrrissoft.simpletodolist.ads.android.ShowAdManager
import com.chrrissoft.simpletodolist.ads.android.ShowAdWorker
import javax.inject.Inject

class SimpleTodoListWorkerFactory @Inject constructor(
    private val manager: ShowAdManager,
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            ShowAdWorker::class.java.name -> ShowAdWorker(appContext, workerParameters, manager)
            else -> null
        }
    }
}
