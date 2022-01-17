/*
 *
 * Created by doaafouad on 1/17/22 5:59 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 5:59 AM
 *
 *
 */

package com.doaa.domain.common


sealed class Unit(val description: String) : Exception(description) {
    object Fahrenheit : Unit("imperial")
    object Celsius : Unit("metric")
}