/*
 *
 * Created by doaafouad on 1/17/22 5:40 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 5:40 AM
 *
 *
 */

package com.doaa.data.repositories

import com.doaa.data.cache.sharedpref.SharedPreferencesWrapper

class SettingsRepository(private val wrapper: SharedPreferencesWrapper) {

    fun getUnit() =
        wrapper.getString(UNIT, "metric") ?: ""

    fun setUnit(unit: String) =
        wrapper.putString(UNIT, unit)

    private val UNIT = "unit"

}