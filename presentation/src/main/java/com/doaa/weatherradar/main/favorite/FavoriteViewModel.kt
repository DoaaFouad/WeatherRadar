/*
 *
 * Created by doaafouad on 1/16/22 11:38 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:38 PM
 *
 *
 */

package com.doaa.weatherradar.main.favorite

import com.doaa.data.repositories.FavoriteCacheRepository
import com.doaa.domain.common.Error
import com.doaa.weatherradar.base.BaseViewModel

class FavoriteViewModel(val favoriteCacheRepository: FavoriteCacheRepository) :
    BaseViewModel<FavoriteContract.Intent, FavoriteContract.State, FavoriteContract.Effect>() {

    override fun createInitialState(): FavoriteContract.State {
        return FavoriteContract.State(FavoriteContract.FavoriteViewState.Idle)
    }

    override suspend fun handleIntent(intent: FavoriteContract.Intent) {
        when (intent) {
            is FavoriteContract.Intent.GetFavorites -> {
                getFavoriteList()
            }
        }
    }

    private suspend fun getFavoriteList() {
        try {
            val response = favoriteCacheRepository.getFavoriteList().await()

            setState {
                copy(
                    favoriteViewState = FavoriteContract.FavoriteViewState.GetFavoriteSuccess(
                        favoriteList = response
                    )
                )
            }

        } catch (e: Exception) {
            e.printStackTrace()
            setEffect { FavoriteContract.Effect.ShowServerErrorToast(Error.Invalid.description) }
        }
    }
}