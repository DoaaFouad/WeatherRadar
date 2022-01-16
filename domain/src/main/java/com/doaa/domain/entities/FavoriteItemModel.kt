/*
 *
 * Created by doaafouad on 1/16/22 10:59 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 10:59 PM
 *
 *
 */

package com.doaa.domain.entities

data class FavoriteItemModel(
    val city: String?,
    val lat: String?,
    val lng: String?,
    val lastTemperature: String?
) : ItemModel