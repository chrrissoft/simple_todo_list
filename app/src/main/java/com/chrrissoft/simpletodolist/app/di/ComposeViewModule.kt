package com.chrrissoft.simpletodolist.app.di

import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.chrrissoft.simpletodolist.SimpleTodoApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ComposeViewModule {
    @Provides
    fun provide(
        owner: LifecycleOwner,
        stateOwner: SavedStateRegistryOwner,
        app: SimpleTodoApp,
    ): ComposeView = ComposeView(app).apply {
        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        setViewTreeLifecycleOwner(owner)
        setViewTreeSavedStateRegistryOwner(stateOwner)
    }
}
