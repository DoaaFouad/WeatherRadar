/*
 *
 * Created by doaafouad on 1/16/22 3:59 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:59 PM
 *
 *
 */

package com.doaa.data.mappers

import com.doaa.data.remote.model.*
import com.doaa.domain.common.getDayFromTimeStamp
import com.doaa.domain.entities.*

class WeatherMapper :
    ItemMapper<WeatherRemoteResponse?, WeatherItemModel> {
    override fun mapFromItem(model: WeatherItemModel): WeatherRemoteResponse {
        throw UnsupportedOperationException()
    }

    override fun mapToItem(model: WeatherRemoteResponse?): WeatherItemModel {
        return WeatherItemModel(
            name = model?.name?.substringAfter("/").toString(),
            lat = model?.lat,
            lng = model?.lng,
            current = WeatherDetailsMapper().mapToItem(model = model?.current),
            daily = model?.weeklyWeather?.map {
                WeatherWeeklyDetailsMapper().mapToItem(it)
            },
            unit = null
        )
    }
}

class WeatherDetailsMapper :
    ItemMapper<WeatherDetailsRemoteResponse?, WeatherDetailsItemModel> {
    override fun mapFromItem(model: WeatherDetailsItemModel): WeatherDetailsRemoteResponse {
        throw UnsupportedOperationException()
    }

    override fun mapToItem(model: WeatherDetailsRemoteResponse?): WeatherDetailsItemModel {
        return WeatherDetailsItemModel(
            temp = model?.temp,
            feelsLike = model?.feelsLike,
            tempMin = model?.tempMin,
            tempMax = model?.tempMax,
            pressure = model?.pressure,
            humidity = model?.humidity,
            seaLevel = model?.seaLevel,
            grndLevel = model?.grndLevel,
            weatherState = model?.weatherState?.map {
                WeatherStateMapper().mapToItem(it)
            }
        )
    }
}

class WeatherStateMapper :
    ItemMapper<WeatherStateRemoteResponse?, WeatherStateItemModel> {
    override fun mapFromItem(model: WeatherStateItemModel): WeatherStateRemoteResponse {
        throw UnsupportedOperationException()
    }

    override fun mapToItem(model: WeatherStateRemoteResponse?): WeatherStateItemModel {
        return WeatherStateItemModel(
            main = model?.main,
        )
    }
}

class WeatherWeeklyDetailsMapper :
    ItemMapper<WeatherWeaklyDetailsRemoteResponse?, WeatherDailyDetailsItemModel> {
    override fun mapFromItem(model: WeatherDailyDetailsItemModel): WeatherWeaklyDetailsRemoteResponse {
        throw UnsupportedOperationException()
    }

    override fun mapToItem(model: WeatherWeaklyDetailsRemoteResponse?): WeatherDailyDetailsItemModel {
        return WeatherDailyDetailsItemModel(
            temp = WeatherTemperatureItemModel(model?.temp?.day),
            date = model?.date?.getDayFromTimeStamp(),
            weatherState = model?.weatherState?.map {
                WeatherStateMapper().mapToItem(it)
            }
        )
    }
}

// used for /weather api as it has different api response structure
class WeatherSingleResponseMapper :
    ItemMapper<WeatherSingleRemoteResponse?, WeatherItemModel> {
    override fun mapFromItem(model: WeatherItemModel): WeatherSingleRemoteResponse {
        throw UnsupportedOperationException()
    }

    override fun mapToItem(model: WeatherSingleRemoteResponse?): WeatherItemModel {
        return WeatherItemModel(
            name = "",
            lat = model?.coordinates?.lat,
            lng = model?.coordinates?.lng,
            current = null,
            daily = null,
            unit = null
        )
    }
}
