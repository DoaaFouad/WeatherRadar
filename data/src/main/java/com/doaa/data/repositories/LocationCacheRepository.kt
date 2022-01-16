/*
 *
 * Created by doaafouad on 1/16/22 3:44 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 1:48 PM
 *
 *
 */

package com.doaa.data.repositories

import com.doaa.anonymouschat.data.cache.SharedPreferencesWrapper


class LocationCacheRepository(private val wrapper: SharedPreferencesWrapper) {

    fun getLocationLat() =
        wrapper.getString(LOCATION_LAT, "") ?: ""

    fun setLocationLat(lat: String) =
        wrapper.putString(LOCATION_LAT, lat)

    fun getLocationLng() =
        wrapper.getString(LOCATION_LNG, "") ?: ""

    fun setLocationLng(lng: String) =
        wrapper.putString(LOCATION_LNG, lng)


    private val LOCATION_LAT = "location_lat"
    private val LOCATION_LNG = "location_lng"

}