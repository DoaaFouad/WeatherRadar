/*
 *
 * Created by doaafouad on 1/16/22 12:04 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 12:04 PM
 *
 *
 */

package com.doaa.weatherradar.main.weather_details

import android.location.Location
import com.doaa.anonymouschat.data.cache.LocationCacheRepository
import com.doaa.weatherradar.base.BaseViewModel

class WeatherDetailsViewModel(val locationCacheRepository: LocationCacheRepository) :
    BaseViewModel<WeatherDetailsContract.Intent, WeatherDetailsContract.State, WeatherDetailsContract.Effect>() {

    override fun createInitialState(): WeatherDetailsContract.State {
        return WeatherDetailsContract.State(WeatherDetailsContract.WeatherDetailsViewState.Idle)
    }

    override suspend fun handleIntent(intent: WeatherDetailsContract.Intent) {
        when (intent) {
            is WeatherDetailsContract.Intent.GetWeatherByCurrentLocation -> {
            }

            is WeatherDetailsContract.Intent.SaveLastKnownLocation -> {
                saveLastKnownLocation(intent.location)
            }
        }
    }

    private fun saveLastKnownLocation(location: Location) {
        locationCacheRepository.setLocationLng(location.longitude.toString())
        locationCacheRepository.setLocationLat(location.latitude.toString())
    }
}