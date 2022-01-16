/*
 *
 * Created by doaafouad on 1/16/22 11:37 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:37 PM
 *
 *
 */

package com.doaa.weatherradar.main.favorite

import android.location.Location
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.doaa.domain.entities.FavoriteItemModel
import com.doaa.weatherradar.base.BaseActivity
import com.doaa.weatherradar.databinding.ActivityFavoriteBinding
import com.doaa.weatherradar.main.weather_details.WeatherDetailsActivity
import com.doaa.weatherradar.utils.BundleKeys
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity :
    BaseActivity<FavoriteContract.Intent, FavoriteContract.State, FavoriteContract.Effect, ActivityFavoriteBinding>() {

    override val viewModel by viewModel<FavoriteViewModel>()

    private var adapter : FavoriteAdapter ? = null

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.favoriteViewState) {
                    is FavoriteContract.FavoriteViewState.Idle -> {

                    }

                    is FavoriteContract.FavoriteViewState.GetFavoriteSuccess -> {
                        populateData(state.favoriteList)
                    }
                }

            }
        }
    }

    override fun init() {
        super.init()

        initRecyclerviewer()
        viewModel.setIntent(FavoriteContract.Intent.GetFavorites)
    }

    override fun setListeners() {
        super.setListeners()
    }

    private fun initRecyclerviewer() {
        binding?.rvFavorite?.layoutManager =
            LinearLayoutManager(this)
        adapter = FavoriteAdapter(object : FavoriteListener{
            override fun onItemClicked(lat: String?, lng: String?) {
                navigateToFavorite(lat, lng)
            }

        })
        binding?.rvFavorite?.adapter = adapter
    }

    private fun populateData(favoriteData: List<FavoriteItemModel>?) {
        adapter?.setData(favoriteData)
    }

    private fun navigateToFavorite(lat: String?, lng: String?){
        val bundle = Bundle()
        bundle.putString(BundleKeys.KEY_LAT, lat)
        bundle.putString(BundleKeys.KEY_LNG, lng)
        navigateToActivity(WeatherDetailsActivity::class.java, bundle)
        finishAffinity()
    }

    override fun getViewBinding(): ActivityFavoriteBinding {
        return ActivityFavoriteBinding.inflate(layoutInflater)
    }
}