/*
 *
 * Created by doaafouad on 1/16/22 3:27 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:27 PM
 *
 *
 */

package com.doaa.domain.entities

import com.doaa.domain.common.Unit

data class WeatherItemModel(
    val name: String?,
    val lat: String?,
    val lng: String?,
    val current: WeatherDetailsItemModel?,
    val daily: List<WeatherDailyDetailsItemModel>?,
    var unit: Unit?
) : ItemModel

data class WeatherDetailsItemModel(
    val temp: String?,
    val feelsLike: String?,
    val tempMin: String?,
    val tempMax: String?,
    val pressure: String?,
    val humidity: String?,
    val seaLevel: String?,
    val grndLevel: String?,
    val weatherState: List<WeatherStateItemModel>?
) : ItemModel

data class WeatherStateItemModel(
    val main: String?,
) : ItemModel

data class WeatherDailyDetailsItemModel(
    val temp: WeatherTemperatureItemModel?,
    val date: String?,
    val weatherState: List<WeatherStateItemModel>?
) : ItemModel


data class WeatherTemperatureItemModel(
    val day: String?
) : ItemModel