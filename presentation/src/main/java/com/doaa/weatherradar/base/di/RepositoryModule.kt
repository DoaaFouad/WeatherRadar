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
import com.doaa.data.repositories.LocationCacheRepository
import com.doaa.data.cache.sharedpref.SharedPreferencesWrapper
import com.doaa.data.repositories.FavoriteCacheRepository
import com.doaa.data.repositories.WeatherRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single { WeatherRepository(get()) }
    single { LocationCacheRepository(get()) }
    single { FavoriteCacheRepository(get()) }
    single {
        SharedPreferencesWrapper(
           sharedPreferences = this.androidContext().getSharedPreferences(
              "WeatherRadar",
              Context.MODE_PRIVATE,
           ),
        )
    }
}