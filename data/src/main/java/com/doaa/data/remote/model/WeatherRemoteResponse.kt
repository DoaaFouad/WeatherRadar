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

    @SerializedName("name")
    val name: String?,

    @SerializedName("main")
    val main: WeatherDetailsRemoteResponse?,
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
    val grndLevel: String?
)
