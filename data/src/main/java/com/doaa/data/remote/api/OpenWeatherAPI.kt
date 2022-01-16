/*
 *
 * Created by doaafouad on 1/16/22 12:16 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 12:16 PM
 *
 *
 */

package com.doaa.data.remote.api

import com.doaa.data.remote.model.WeatherRemoteResponse
import com.doaa.data.remote.model.WeatherSingleRemoteResponse
import com.doaa.data.utils.RemoteConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {

    @GET(RemoteConstants.EndPoint.GET_WEATHER_GEO_COORDINATES)
    suspend fun getWeatherByLatLng(
        @Query("lat") lat: String?,
        @Query("lon") lng: String?,
        @Query("units") unit: String = "metric",
        @Query("exclude") exclude: String = "hourly,minutely",
        @Query("appid") appId: String = RemoteConstants.Base.API_KEY,
    ): WeatherRemoteResponse

    @GET(RemoteConstants.EndPoint.GET_WEATHER_BY_CITY)
    suspend fun getWeatherByCityKeyword(
        @Query("q") city: String?,
        @Query("appid") appId: String = RemoteConstants.Base.API_KEY,
    ): WeatherSingleRemoteResponse
}