/*
 * *
 * Created by Doaa Fouad on 1/14/22 5:33 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 5:33 PM
 *
 */

package com.doaa.anonymouschat.data.cache

import android.content.SharedPreferences

open class SharedPreferencesWrapper(
    var sharedPreferences: SharedPreferences,
) {
    open fun getString(name: String, defVal: String): String? =
        sharedPreferences.getString(name, defVal)

    open fun putString(name: String, value: String) =
        sharedPreferences.edit().putString(name, value).apply()

    open fun getInt(name: String, defVal: Int): Int? =
        sharedPreferences.getInt(name, defVal)

    open fun putInt(name: String, value: Int) =
        sharedPreferences.edit().putInt(name, value).apply()
}