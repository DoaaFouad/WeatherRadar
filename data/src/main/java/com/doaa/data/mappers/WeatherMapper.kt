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

import com.doaa.data.remote.model.WeatherDetailsRemoteResponse
import com.doaa.data.remote.model.WeatherRemoteResponse
import com.doaa.domain.entities.WeatherDetailsItemModel
import com.doaa.domain.entities.WeatherItemModel

class WeatherMapper :
    ItemMapper<WeatherRemoteResponse?, WeatherItemModel> {
    override fun mapFromItem(model: WeatherItemModel): WeatherRemoteResponse {
        throw UnsupportedOperationException()
    }

    override fun mapToItem(model: WeatherRemoteResponse?): WeatherItemModel {
        return WeatherItemModel(
            name = model?.name.toString(),
            main = WeatherDetailsMapper().mapToItem(model = model?.main)
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
            grndLevel = model?.grndLevel
        )
    }
}