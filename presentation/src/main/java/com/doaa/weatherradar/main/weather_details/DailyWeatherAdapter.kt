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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doaa.domain.entities.WeatherDailyDetailsItemModel
import com.doaa.weatherradar.databinding.RowDailyWeatherBinding

class DailyWeatherAdapter() : RecyclerView.Adapter<DailyWeatherViewHolder>() {

    private var dailyDataList : List<WeatherDailyDetailsItemModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyWeatherViewHolder {
        val itemBinding = RowDailyWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DailyWeatherViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return dailyDataList.size
    }

    override fun onBindViewHolder(holder: DailyWeatherViewHolder, position: Int) {
        return holder.initRow(dailyDataList[position], position == 0)
    }

    fun setData(dailyWeatherData: List<WeatherDailyDetailsItemModel>?) {
        dailyWeatherData?.let {
            dailyDataList = dailyWeatherData
        }
        notifyDataSetChanged()
    }
}