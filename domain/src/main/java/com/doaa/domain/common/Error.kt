/*
 *
 * Created by doaafouad on 1/16/22 3:38 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:27 PM
 *
 *
 */

package com.doaa.domain.common

// used for logging
sealed class Error(val description: String) : Exception(description) {
    object NoLocationPermissionGranted : Error("No Location Permission Granted")
    object GeneralRequestError : Error("Error Requesting Data!")
    object Invalid : Error("Invalid")
}