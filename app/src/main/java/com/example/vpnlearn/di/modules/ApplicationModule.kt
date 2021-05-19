package com.example.vpnlearn.di.modules

import android.content.Context
import androidx.room.Room
import com.example.vpnlearn.data.local.DatabaseService
import com.example.vpnlearn.di.qualifire.ApplicationContext
import com.example.vpnlearn.MyApplication
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @Singleton
    @Provides
    fun provideDatabaseService(): DatabaseService = Room.databaseBuilder(
        application,
        DatabaseService::class.java,
        "net_blocker_db"
    ).build()

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
}