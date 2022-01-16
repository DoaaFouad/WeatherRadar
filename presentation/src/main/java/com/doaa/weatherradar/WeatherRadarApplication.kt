/*
 *
 * Created by doaafouad on 1/16/22 11:52 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:52 AM
 *
 *
 */

package com.doaa.weatherradar

import android.app.Application
import com.doaa.weatherradar.base.di.repositoryModule
import com.doaa.weatherradar.base.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class WeatherRadarApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidLogger()
            androidContext(this@WeatherRadarApplication)
            modules(listOf(viewModelModule, repositoryModule))
        }
    }
}