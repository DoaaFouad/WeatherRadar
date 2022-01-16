/*
 *
 * Created by doaafouad on 1/16/22 12:00 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 12:00 PM
 *
 *
 */

package com.doaa.weatherradar.main.weather_details

import androidx.lifecycle.lifecycleScope
import com.doaa.weatherradar.base.BaseActivity
import com.doaa.weatherradar.databinding.ActivityWeatherDetailsBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherDetailsActivity :
    BaseActivity<WeatherDetailsContract.Intent, WeatherDetailsContract.State, WeatherDetailsContract.Effect, ActivityWeatherDetailsBinding>() {

    override val viewModel by viewModel<WeatherDetailsViewModel>()

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.weatherDetailsViewState) {
                    is WeatherDetailsContract.WeatherDetailsViewState.Idle -> {

                    }
                }

            }
        }
    }

    override fun setListeners() {
        super.setListeners()
    }


    override fun getViewBinding(): ActivityWeatherDetailsBinding {
        return ActivityWeatherDetailsBinding.inflate(layoutInflater)
    }
}