/*
 *
 * Created by doaafouad on 1/16/22 12:01 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 12:01 PM
 *
 *
 */

package com.doaa.weatherradar.main.weather_details

import com.doaa.weatherradar.base.ViewEffect
import com.doaa.weatherradar.base.ViewIntent
import com.doaa.weatherradar.base.ViewState

class WeatherDetailsContract {

    sealed class Intent : ViewIntent {
        object GetWeatherByCurrentLocation : Intent()
    }

    data class State(
        val weatherDetailsViewState: WeatherDetailsViewState
    ) : ViewState

    sealed class WeatherDetailsViewState {
        object Idle : WeatherDetailsViewState()
        object Loading : WeatherDetailsViewState()
    }

    sealed class Effect : ViewEffect {
        data class ShowServerErrorToast(val message: String) : Effect()
    }
}