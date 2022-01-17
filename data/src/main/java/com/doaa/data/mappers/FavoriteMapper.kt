/*
 *
 * Created by doaafouad on 1/16/22 11:02 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:02 PM
 *
 *
 */

package com.doaa.data.mappers

import com.doaa.data.cache.room.favorite.Favorite
import com.doaa.domain.entities.FavoriteItemModel

class FavoriteMapper :
    ItemMapper<Favorite?, FavoriteItemModel> {
    override fun mapFromItem(model: FavoriteItemModel): Favorite {
        return Favorite(
            uid = 0,
            city = model.city,
            latitude = model.lat,
            longitude = model.lng,
            lastTemperature = model.lastTemperature,
            unit = model.unit
        )
    }

    override fun mapToItem(model: Favorite?): FavoriteItemModel {
        return FavoriteItemModel(
            city = model?.city,
            lat = model?.latitude,
            lng = model?.longitude,
            lastTemperature = model?.lastTemperature,
            unit = model?.unit
        )
    }
}
