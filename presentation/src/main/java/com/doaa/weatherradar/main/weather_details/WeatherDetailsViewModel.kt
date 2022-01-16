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
import android.util.Log
import com.doaa.data.repositories.LocationCacheRepository
import com.doaa.data.repositories.WeatherRepository
import com.doaa.domain.common.Error
import com.doaa.weatherradar.base.BaseViewModel

class WeatherDetailsViewModel(
    val locationCacheRepository: LocationCacheRepository,
    val weatherRepository: WeatherRepository
) :
    BaseViewModel<WeatherDetailsContract.Intent, WeatherDetailsContract.State, WeatherDetailsContract.Effect>() {

    override fun createInitialState(): WeatherDetailsContract.State {
        return WeatherDetailsContract.State(WeatherDetailsContract.WeatherDetailsViewState.Idle)
    }

    override suspend fun handleIntent(intent: WeatherDetailsContract.Intent) {
        when (intent) {
            is WeatherDetailsContract.Intent.GetWeatherByCurrentLocation -> {
                getWeatherByLocation()
            }

            is WeatherDetailsContract.Intent.SaveLastKnownLocation -> {
                saveLastKnownLocation(intent.location)
            }
        }
    }

    private suspend fun getWeatherByLocation() {
        setState { copy(weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.Loading) }
        try {
            val currentLat = locationCacheRepository.getLocationLat()
            val currentLng = locationCacheRepository.getLocationLng()

            val response = weatherRepository.getWeatherByLatLng(currentLat, currentLng).await()

            setState {
                copy(
                    weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.WeatherDetailsSuccess(
                        weatherData = response
                    )
                )
            }

        } catch (e: Exception) {
            setState { copy(weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.Idle) }
            setEffect { WeatherDetailsContract.Effect.ShowServerErrorToast(Error.GeneralRequestError.description) }
        }
    }

    private fun saveLastKnownLocation(location: Location) {
        locationCacheRepository.setLocationLng(location.longitude.toString())
        locationCacheRepository.setLocationLat(location.latitude.toString())
    }
}