/*
 *
 * Created by doaafouad on 1/16/22 12:18 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 12:18 PM
 *
 *
 */

package com.doaa.weatherradar.base.di

import com.doaa.data.remote.builder.OkHttpBuilder
import com.doaa.data.remote.builder.RetrofitBuilder
import org.koin.dsl.module

val apiModule = module {
    single { RetrofitBuilder(get()).openWeatherAPI }
    single { OkHttpBuilder() }
}