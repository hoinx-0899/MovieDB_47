package com.sun.moviedb

import android.app.Application
import android.content.Context
import com.sun.moviedb.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by nguyenxuanhoi on 2019-08-05.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidLogger()
            androidContext(this@MovieApplication)
            modules(listOf(remoteModule))
        }
    }

    companion object {
        lateinit var INSTANCE: MovieApplication
            private set
        val applicationContext: Context?
            get() = if (::INSTANCE.isInitialized) INSTANCE.applicationContext else null
    }
}
