package com.chrrissoft.simpletodolist.ads.android

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import com.chrrissoft.simpletodolist.ads.view.AdBanner
import com.chrrissoft.simpletodolist.app.entities.LifecycleManager
import com.chrrissoft.simpletodolist.R
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.random.Random.Default.nextInt
import kotlin.time.DurationUnit.MINUTES
import kotlin.time.toDuration

class ShowAdManager @Inject constructor(
    private val compose: ComposeView,
    private val lifecycleManager: LifecycleManager,
) {
    fun load() {
        lifecycleManager.launch()
        compose.setContent {
            LaunchedEffect(Unit) {
                val disposeRange = nextInt(from = 3, until = 6).toDuration(MINUTES)
                delay(disposeRange)
                dispose()
            }
            AdBanner(stringResource(R.string.banner_id), Modifier.alpha(0f))
        }
    }

    private fun dispose() {
        compose.setContent { }
        lifecycleManager.dispose()
    }
}
