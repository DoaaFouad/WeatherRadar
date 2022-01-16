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

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.doaa.domain.base.Error
import com.doaa.weatherradar.base.BaseActivity
import com.doaa.weatherradar.databinding.ActivityWeatherDetailsBinding
import com.doaa.weatherradar.main.location.LastKnownLocationManager
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherDetailsActivity :
    BaseActivity<WeatherDetailsContract.Intent, WeatherDetailsContract.State, WeatherDetailsContract.Effect, ActivityWeatherDetailsBinding>() {

    override val viewModel by viewModel<WeatherDetailsViewModel>()

    private val lastKnownLocationManager by inject<LastKnownLocationManager>()

    override fun init() {
        super.init()

        lastKnownLocationManager.execute(onSuccess = {
            viewModel.setIntent(WeatherDetailsContract.Intent.SaveLastKnownLocation(it))
        }, requestLocationPermission = {
            locationPermissionRequest.launch(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        })
    }

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

    // Permissions
    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                lastKnownLocationManager.execute()
            }
            else -> {
                showLongToast(Error.NoLocationPermissionGranted.description) // TODO localizable
            }
        }
    }

    override fun getViewBinding(): ActivityWeatherDetailsBinding {
        return ActivityWeatherDetailsBinding.inflate(layoutInflater)
    }
}