/*
 *
 * Created by doaafouad on 1/16/22 11:50 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:50 AM
 *
 *
 */

package com.doaa.weatherradar.base.di

import android.content.Context
import com.doaa.anonymouschat.data.cache.LocationCacheRepository
import com.doaa.anonymouschat.data.cache.SharedPreferencesWrapper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single { LocationCacheRepository(get()) }
    single {
        SharedPreferencesWrapper(
           sharedPreferences = this.androidContext().getSharedPreferences(
              "WeatherRadar",
              Context.MODE_PRIVATE,
           ),
        )
    }
}