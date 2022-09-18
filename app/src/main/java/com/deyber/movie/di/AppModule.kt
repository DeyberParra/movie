package com.deyber.movie.di

import android.content.Context
import androidx.lifecycle.LiveData
import com.deyber.movie.data.firebase.LocationLiveData
import com.deyber.movie.data.firebase.model.LocationModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
 object AppModule {

  @Singleton
  @Provides
  fun providesLocationLiveData(@ApplicationContext context:Context):LocationLiveData{
   return LocationLiveData(context)
  }

}