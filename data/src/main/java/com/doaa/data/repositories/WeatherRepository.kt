/*
 *
 * Created by doaafouad on 1/16/22 3:44 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:43 PM
 *
 *
 */

package com.doaa.data.repositories

import android.location.Location
import com.doaa.data.mappers.Mappers
import com.doaa.data.remote.api.OpenWeatherAPI
import com.doaa.domain.entities.WeatherItemModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class WeatherRepository(val openWeatherAPI: OpenWeatherAPI) : BaseRespository() {

    suspend fun getWeatherByLatLng(_lat: String, _lng: String): Deferred<WeatherItemModel> =
        withContext(dispatcherIO) {
            async {
                val weatherData =
                    openWeatherAPI.getWeatherByLatLng(
                        lat = _lat,
                        lng = _lng,
                    )

               val response =  Mappers.weatherResponseMapper.mapToItem(weatherData)

                response
            }
        }
}