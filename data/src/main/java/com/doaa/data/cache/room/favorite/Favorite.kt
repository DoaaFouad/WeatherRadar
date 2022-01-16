/*
 *
 * Created by doaafouad on 1/16/22 10:05 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 10:05 PM
 *
 *
 */

package com.doaa.data.cache.room.favorite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "city") var city: String? = "",
    @ColumnInfo(name = "lat") var latitude: String? = "",
    @ColumnInfo(name = "lng") var longitude: String? = "",
    @ColumnInfo(name = "last_temperature") var lastTemperature: String? = "",
)