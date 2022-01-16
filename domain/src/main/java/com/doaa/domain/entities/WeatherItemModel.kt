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

data class WeatherItemModel(
    val name: String,
    val main : WeatherDetailsItemModel
) : ItemModel

data class WeatherDetailsItemModel(
    val temp: String?,
    val feelsLike: String?,
    val tempMin: String?,
    val tempMax: String?,
    val pressure: String?,
    val humidity: String?,
    val seaLevel: String?,
    val grndLevel: String?
) : ItemModel