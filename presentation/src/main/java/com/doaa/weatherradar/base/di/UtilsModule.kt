/*
 *
 * Created by doaafouad on 1/16/22 1:07 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 1:07 PM
 *
 *
 */

package com.doaa.weatherradar.base.di

import com.doaa.weatherradar.main.location.LastKnownLocationManager
import com.doaa.weatherradar.main.weather_details.DailyWeatherAdapter
import com.emc.voicenote.room.DatabaseBuilder
import com.emc.voicenote.room.DatabaseInteractor
import org.koin.dsl.module

val utilsModule = module {
    single { LastKnownLocationManager(get()) }
    single { DailyWeatherAdapter() }
    single { DatabaseBuilder.buildRoomDB(get()) }
    single { DatabaseInteractor(get()) }
}