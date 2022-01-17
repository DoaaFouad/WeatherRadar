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
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.doaa.domain.common.Error
import com.doaa.domain.entities.WeatherDailyDetailsItemModel
import com.doaa.domain.entities.WeatherItemModel
import com.doaa.weatherradar.R
import com.doaa.weatherradar.base.BaseActivity
import com.doaa.weatherradar.databinding.ActivityWeatherDetailsBinding
import com.doaa.weatherradar.main.favorite.FavoriteActivity
import com.doaa.weatherradar.main.location.LastKnownLocationManager
import com.doaa.weatherradar.utils.BundleKeys
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class WeatherDetailsActivity :
    BaseActivity<WeatherDetailsContract.Intent, WeatherDetailsContract.State, WeatherDetailsContract.Effect, ActivityWeatherDetailsBinding>() {

    override val viewModel by viewModel<WeatherDetailsViewModel>()

    private val lastKnownLocationManager by inject<LastKnownLocationManager>()
    private val dailyWeatherAdapter by inject<DailyWeatherAdapter>()

    override fun init() {
        super.init()

        initRecyclerviewer()
        //initPlacesAutoComplete() // TODO Places API needs google account to be enabled billing, this would be easier to get latlng and pass it to API
        initUnfavorited()

        val lat = intent.extras?.getString(BundleKeys.KEY_LAT)
        val lng = intent.extras?.getString(BundleKeys.KEY_LNG)
        if (lat == null || lng == null) {
            getLastKnownLocation()
        } else {
            viewModel.setIntent(WeatherDetailsContract.Intent.GetWeatherBySelectedLatLng(lat, lng))
        }
    }

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.weatherDetailsViewState) {
                    is WeatherDetailsContract.WeatherDetailsViewState.Idle -> {

                    }

                    is WeatherDetailsContract.WeatherDetailsViewState.InfoFavorite -> {
                        if(state.isFavorited){
                            initFavorited()
                        }
                    }

                    is WeatherDetailsContract.WeatherDetailsViewState.WeatherDetailsSuccess -> {
                        initWeatherDetails(state.weatherData)
                    }
                }

            }
        }
    }

    override fun setListeners() {
        super.setListeners()

        binding?.ivFavorite?.setOnClickListener {
            viewModel.setIntent(WeatherDetailsContract.Intent.AddCurrentWeatherInfoFavorite)
            initFavorited()
        }

        binding?.ivFavoriteHighlighted?.setOnClickListener {
          //   initUnfavorited() // TODO unfavorite behaviour
        }

        binding?.ivMenuFavorite?.setOnClickListener {
            navigateToFavorite()
        }

        binding?.etSearch?.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun getLastKnownLocation() {
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    lastKnownLocationManager.execute(onSuccess = {
                        viewModel.setIntent(WeatherDetailsContract.Intent.SaveLastKnownLocation(it))
                        viewModel.setIntent(WeatherDetailsContract.Intent.GetWeatherByCurrentLocation)
                    })
                }
                else -> {
                    showLongToast(Error.NoLocationPermissionGranted.description) // TODO localizable
                }
            }
        }

        lastKnownLocationManager.execute(
            onSuccess = {
                viewModel.setIntent(WeatherDetailsContract.Intent.SaveLastKnownLocation(it))
                viewModel.setIntent(WeatherDetailsContract.Intent.GetWeatherByCurrentLocation)
            }, requestLocationPermission = {
                locationPermissionRequest.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            })
    }

    private fun initWeatherDetails(weatherData: WeatherItemModel) {
        binding?.tvCityName?.text = weatherData.name
        binding?.tvCityWeatherState?.text = weatherData.current?.weatherState?.getOrNull(0)?.main
        binding?.tvCityTemperature?.text =
            "${weatherData.current?.temp} ${getString(R.string.weather_unit)}"
        binding?.tvCityFeelsLike?.text =
            "${getString(R.string.weather_details_feels_like)} : ${weatherData.current?.feelsLike} ${
                getString(
                    R.string.weather_unit
                )
            }"
        binding?.tvCityHumidity?.text =
            "${getString(R.string.weather_details_humidity)} : ${weatherData.current?.humidity}%"

        populateData(weatherData.daily)
    }


    private fun initRecyclerviewer() {
        binding?.rvDaily?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding?.rvDaily?.adapter = dailyWeatherAdapter
    }

    private fun populateData(dailyWeatherData: List<WeatherDailyDetailsItemModel>?) {
        dailyWeatherAdapter.setData(dailyWeatherData)
    }

    private fun initFavorited() {
        binding?.ivFavorite?.visibility = View.GONE
        binding?.ivFavoriteHighlighted?.visibility = View.VISIBLE
    }

    private fun initUnfavorited() {
        binding?.ivFavorite?.visibility = View.VISIBLE
        binding?.ivFavoriteHighlighted?.visibility = View.GONE
    }

    private fun navigateToFavorite() {
        navigateToActivity(FavoriteActivity::class.java)
    }

    private fun performSearch() {
        initUnfavorited()
        viewModel.setIntent(WeatherDetailsContract.Intent.GetWeatherByCityKeyword(binding?.etSearch?.text.toString()))
        hideKeyboard()
        binding?.etSearch?.text?.clear()
    }

    // TODO Future work
    private fun initPlacesAutoComplete() {
        /* val apiKey = getString(R.string.place_api_key)
         if (!Places.isInitialized()) {
         }
         val placesClient = Places.createClient(this)
        val autocompleteFragment =
         supportFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment?

         autocompleteFragment?.setPlaceFields(
             listOf(
                 Place.Field.ID,
                 Place.Field.NAME,
                 Place.Field.LAT_LNG
             )
         )

         autocompleteFragment?.setOnPlaceSelectedListener(object : PlaceSelectionListener {
             override fun onPlaceSelected(place: Place) {
             }

             override fun onError(status: Status) {
             }
         })*/
    }

    override fun getViewBinding(): ActivityWeatherDetailsBinding {
        return ActivityWeatherDetailsBinding.inflate(layoutInflater)
    }
}