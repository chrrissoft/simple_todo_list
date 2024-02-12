package com.chrrissoft.simpletodolist

import android.app.Application
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class SimpleTodoApp : Application(), Configuration.Provider {
    @Inject
    lateinit var workConfiguration: Configuration

    override val workManagerConfiguration by lazy { workConfiguration }
}
