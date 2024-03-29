/*
 *
 * Created by doaafouad on 1/17/22 3:55 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 3:55 AM
 *
 *
 */

package com.doaa.data.utils

class RemoteConstants {
    object Base {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val API_KEY = "8b6482e1a498a5b9bc2fff0dda10076e"
    }

    object EndPoint {
        const val GET_WEATHER_GEO_COORDINATES = "data/2.5/onecall"
        const val GET_WEATHER_BY_CITY = "data/2.5/weather"
    }
}