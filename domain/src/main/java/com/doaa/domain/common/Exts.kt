/*
 *
 * Created by doaafouad on 1/16/22 7:20 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 7:20 PM
 *
 *
 */

package com.doaa.domain.common

import java.text.SimpleDateFormat
import java.util.*

fun Long.getDayFromTimeStamp(): String? {
    return try {
        val timeD = Date(this * 1000)
        val format = SimpleDateFormat("EEEE")
        val dayString = format.format(timeD)
        dayString
    } catch (e: Exception) {
        null
    }
}