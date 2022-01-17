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

import com.doaa.domain.common.Unit
import com.doaa.domain.entities.FavoriteItemModel
import com.doaa.weatherradar.base.ViewEffect
import com.doaa.weatherradar.base.ViewIntent
import com.doaa.weatherradar.base.ViewState

class FavoriteContract {

    sealed class Intent : ViewIntent {
        object GetFavorites : Intent()
        data class SetSuitableUnit(val unit: Unit): Intent()
    }

    data class State(
        val favoriteViewState: FavoriteViewState
    ) : ViewState

    sealed class FavoriteViewState {
        object Idle : FavoriteViewState()
        object Loading : FavoriteViewState()
        data class GetFavoriteSuccess(val favoriteList: List<FavoriteItemModel>) :
            FavoriteViewState()
    }

    sealed class Effect : ViewEffect {
        data class ShowServerErrorToast(val message: String) : Effect()
    }
}