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
import com.doaa.data.repositories.FavoriteCacheRepository
import com.doaa.data.repositories.LocationCacheRepository
import com.doaa.data.repositories.SettingsRepository
import com.doaa.data.repositories.WeatherRepository
import com.doaa.domain.common.Error
import com.doaa.domain.common.Unit
import com.doaa.domain.entities.FavoriteItemModel
import com.doaa.domain.entities.WeatherItemModel
import com.doaa.weatherradar.base.BaseViewModel

class WeatherDetailsViewModel(
    val locationCacheRepository: LocationCacheRepository,
    val weatherRepository: WeatherRepository,
    val favoriteCacheRepository: FavoriteCacheRepository,
    val settingsRepository: SettingsRepository
) :
    BaseViewModel<WeatherDetailsContract.Intent, WeatherDetailsContract.State, WeatherDetailsContract.Effect>() {

    private lateinit var weatherItemModel: WeatherItemModel

    override fun createInitialState(): WeatherDetailsContract.State {
        return WeatherDetailsContract.State(WeatherDetailsContract.WeatherDetailsViewState.Idle)
    }

    override suspend fun handleIntent(intent: WeatherDetailsContract.Intent) {
        when (intent) {
            is WeatherDetailsContract.Intent.GetWeatherByCurrentLocation -> {
                getWeatherByLocation()
            }

            is WeatherDetailsContract.Intent.GetWeatherBySelectedLatLng -> {
                getWeatherBySelectedLatLng(intent.lat, intent.lng)
            }

            is WeatherDetailsContract.Intent.GetWeatherByCityKeyword -> {
                getWeatherByCityKeyword(intent.city)
            }

            is WeatherDetailsContract.Intent.SaveLastKnownLocation -> {
                saveLastKnownLocation(intent.location)
            }

            is WeatherDetailsContract.Intent.AddCurrentWeatherInfoFavorite -> {
                addToFavorite()
            }
        }
    }

    private suspend fun getWeatherByLocation() {
        setState { copy(weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.Loading) }
        try {
            val currentLat = locationCacheRepository.getLocationLat()
            val currentLng = locationCacheRepository.getLocationLng()
            val unit =  settingsRepository.getUnit()

            val response = weatherRepository.getWeatherByLatLng(currentLat, currentLng, unit).await()
            response.unit = checkUnit()
            weatherItemModel = response

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

    private suspend fun getWeatherBySelectedLatLng(lat: String?, lng: String?) {
        setState { copy(weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.Loading) }
        try {
            val unit =  settingsRepository.getUnit()
            val response = weatherRepository.getWeatherByLatLng(lat, lng, unit).await()
            weatherItemModel = response
            weatherItemModel.unit = checkUnit()

            setState {
                copy(
                    weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.WeatherDetailsSuccess(
                        weatherData = weatherItemModel
                    )
                )
            }

            checkIfCurrentWeatherInfoIsFavorited(city = response.name)

        } catch (e: Exception) {
            setState { copy(weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.Idle) }
            setEffect { WeatherDetailsContract.Effect.ShowServerErrorToast(Error.GeneralRequestError.description) }
        }
    }

    private suspend fun getWeatherByCityKeyword(city: String) {
        try {
            val response = weatherRepository.getWeatherByCityName(city).await()
            getWeatherBySelectedLatLng(response.lat, response.lng)

        } catch (e: Exception) {
            setState { copy(weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.Idle) }
            setEffect { WeatherDetailsContract.Effect.ShowServerErrorToast(Error.GeneralRequestError.description) }
        }
    }

    private fun saveLastKnownLocation(location: Location) {
        locationCacheRepository.setLocationLng(location.longitude.toString())
        locationCacheRepository.setLocationLat(location.latitude.toString())
    }

    private suspend fun addToFavorite(){
        try {
            if(::weatherItemModel.isInitialized) {
                val favorite = FavoriteItemModel(
                    city = weatherItemModel.name,
                    lat = weatherItemModel.lat,
                    lng = weatherItemModel.lng,
                    lastTemperature = weatherItemModel.current?.temp,
                    unit = when(weatherItemModel.unit) {
                        Unit.Celsius -> "C"
                        else -> "F"
                    }
                )
                favoriteCacheRepository.addToFavorite(favorite)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            setEffect { WeatherDetailsContract.Effect.ShowServerErrorToast(Error.Invalid.description) }
        }
    }

    private suspend fun checkIfCurrentWeatherInfoIsFavorited(city: String?) {
        try {
            val response = favoriteCacheRepository.getFavoriteList().await()
            response.forEach {
                if(it.city == city){
                    setState {
                        copy(
                            weatherDetailsViewState = WeatherDetailsContract.WeatherDetailsViewState.InfoFavorite(
                                isFavorited = true
                            )
                        )
                    }
                }
            }


        } catch (e: Exception) {
            e.printStackTrace()
            setEffect { WeatherDetailsContract.Effect.ShowServerErrorToast(Error.Invalid.description) }
        }
    }

    private fun checkUnit(): Unit {
        val unit = settingsRepository.getUnit()
        return when (unit) {
            Unit.Celsius.description -> {
                Unit.Celsius
            }
            Unit.Fahrenheit.description -> {
                Unit.Fahrenheit
            }
            else -> Unit.Celsius
        }
    }
}