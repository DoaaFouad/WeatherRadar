/*
 *
 * Created by doaafouad on 1/16/22 1:29 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/15/22 5:49 PM
 *
 *
 */

package com.doaa.anonymouschat.data.cache


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