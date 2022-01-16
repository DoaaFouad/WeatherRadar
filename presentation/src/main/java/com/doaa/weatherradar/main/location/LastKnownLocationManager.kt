/*
 *
 * Created by doaafouad on 1/16/22 12:34 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 12:34 PM
 *
 *
 */

package com.doaa.weatherradar.main.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices

class LastKnownLocationManager(val context: Context) {

    val fusedLocationClient by lazy { LocationServices.getFusedLocationProviderClient(context) }

    fun execute(onSuccess: ((Location) -> Unit)? = null, requestLocationPermission: (() -> Unit)? = null) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestLocationPermission?.invoke()
        } else {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    location?.let {
                        onSuccess?.invoke(location)
                    }
                }
        }
    }

}