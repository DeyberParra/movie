package com.deyber.movie.di
import android.content.Context
import com.deyber.movie._utils.constants.RetrofitConstants
import com.deyber.movie.core.sesion.SessionInterceptor
import com.deyber.movie.core.sesion.SessionManager
import com.deyber.movie.data.network.MovieClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideClient(retrofit:Retrofit):MovieClient = retrofit.create(MovieClient::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RetrofitConstants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(sessionInterceptor: SessionInterceptor):OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(sessionInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideSessionInterceptor(sessionManager: SessionManager) = SessionInterceptor(sessionManager)

    @Singleton
    @Provides
    fun provideSessionManager(@ApplicationContext context: Context)=SessionManager(context)



}
