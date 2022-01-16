/*
 *
 * Created by doaafouad on 1/16/22 6:58 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 6:58 PM
 *
 *
 */

package com.doaa.weatherradar.main.weather_details

import androidx.recyclerview.widget.RecyclerView
import com.doaa.domain.entities.WeatherDailyDetailsItemModel
import com.doaa.weatherradar.R
import com.doaa.weatherradar.databinding.RowDailyWeatherBinding

class DailyWeatherViewHolder(
    val rowBinding: RowDailyWeatherBinding) :
    RecyclerView.ViewHolder(rowBinding.root) {

    fun initRow(model: WeatherDailyDetailsItemModel, isFirstIndex: Boolean) {
        if(isFirstIndex) {
            rowBinding.tvDate.text = rowBinding.root.context.getString(R.string.weather_details_today)
        }else{
            rowBinding.tvDate.text = model.date
        }
        rowBinding.tvCityTemperature.text = model.temp?.day
        rowBinding.tvCityWeatherState.text = model.weatherState?.getOrNull(0)?.main
    }
}
