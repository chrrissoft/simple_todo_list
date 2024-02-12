package com.chrrissoft.simpletodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.chrrissoft.simpletodolist.ads.android.ShowAdWorker.Companion.SHOW_ADS_WORK_NAME
import com.chrrissoft.simpletodolist.ads.android.ShowAdWorker.Companion.request
import com.chrrissoft.simpletodolist.navigation.SimpleTodoAppGraph
import com.chrrissoft.simpletodolist.ui.components.SimpleTodoApp
import com.chrrissoft.simpletodolist.utils.Utils.Try
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var workManager: WorkManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enqueueShowAd()
        Try { MobileAds.initialize((this)) { } }
        setContent { SimpleTodoApp { SimpleTodoAppGraph() } }
    }

    private fun enqueueShowAd() {
        lifecycleScope.launch {
            val works = workManager.getWorkInfosForUniqueWorkFlow(SHOW_ADS_WORK_NAME).first()
            if (works.isNotEmpty()) return@launch
            workManager.enqueueUniquePeriodicWork(
                SHOW_ADS_WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP, request().build()
            )
        }
    }
}
