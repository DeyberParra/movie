package com.deyber.movie.di

import android.content.Context
import android.graphics.Color
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.deyber.movie.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(FragmentComponent::class)
object FragmentsModule {

    @Provides
    fun provideCircularProgressBar(@ApplicationContext context: Context):CircularProgressDrawable{
        val progress = CircularProgressDrawable(context)
        progress.strokeWidth = 5f
        progress.centerRadius = 30f
        progress.start()
        return progress
    }
}