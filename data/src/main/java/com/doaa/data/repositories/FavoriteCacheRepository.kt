/*
 *
 * Created by doaafouad on 1/16/22 10:54 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 10:54 PM
 *
 *
 */

package com.doaa.data.repositories

import com.doaa.data.mappers.Mappers.favoriteMapper
import com.doaa.domain.entities.FavoriteItemModel
import com.emc.voicenote.room.DatabaseInteractor
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class FavoriteCacheRepository(
    private val databaseHelper: DatabaseInteractor
): BaseRespository() {

    suspend fun addToFavorite(favoriteItemModel: FavoriteItemModel): Deferred<Unit> =
        withContext(dispatcherIO) {
            async {
                databaseHelper.addFavorite(favoriteMapper.mapFromItem(favoriteItemModel))
            }
        }

    suspend fun getFavoriteList(): Deferred<List<FavoriteItemModel>> =
        withContext(dispatcherIO) {
            async {
                val favoriteDetailsList = databaseHelper.getFavorite()
                favoriteDetailsList.map {
                    favoriteMapper.mapToItem(it)
                }

            }
        }

}