/*
 *
 * Created by doaafouad on 1/16/22 3:09 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:09 PM
 *
 *
 */

package com.doaa.data.remote.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteResponse(

    @SerializedName("timezone")
    val name: String?,

    @SerializedName("lat")
    val lat: String?,

    @SerializedName("lng")
    val lng: String?,

    @SerializedName("current")
    val current: WeatherDetailsRemoteResponse?,

    @SerializedName("daily")
    val weeklyWeather: List<WeatherWeaklyDetailsRemoteResponse?>
)

data class WeatherDetailsRemoteResponse(

    @SerializedName("temp")
    val temp: String?,

    @SerializedName("feels_like")
    val feelsLike: String?,

    @SerializedName("temp_min")
    val tempMin: String?,

    @SerializedName("temp_max")
    val tempMax: String?,

    @SerializedName("pressure")
    val pressure: String?,

    @SerializedName("humidity")
    val humidity: String?,

    @SerializedName("sea_level")
    val seaLevel: String?,

    @SerializedName("grnd_level")
    val grndLevel: String?,

    @SerializedName("weather")
    val weatherState: List<WeatherStateRemoteResponse>

)

data class WeatherStateRemoteResponse(

    @SerializedName("main")
    val main: String?,
)

data class WeatherWeaklyDetailsRemoteResponse(

    @SerializedName("temp")
    val temp: WeatherTemperatureRemoteResponse?,

    @SerializedName("dt")
    val date: Long?,

    @SerializedName("weather")
    val weatherState: List<WeatherStateRemoteResponse>

)

data class WeatherTemperatureRemoteResponse(

    @SerializedName("day")
    val day: String?,
)
