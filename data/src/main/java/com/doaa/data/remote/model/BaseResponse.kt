/*
 *
 * Created by doaafouad on 1/16/22 3:24 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:24 PM
 *
 *
 */

package com.doaa.data.remote.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("code")
    val responseCode: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: T?
) : RemoteModel