/*
 *
 * Created by doaafouad on 1/16/22 11:49 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:49 AM
 *
 *
 */

package com.doaa.weatherradar.base.di

import com.doaa.weatherradar.main.weather_details.WeatherDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { WeatherDetailsViewModel(get()) }
}
