/*
 *
 * Created by doaafouad on 1/16/22 12:12 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 12:12 PM
 *
 *
 */

package com.doaa.data.remote.builder

import com.doaa.data.remote.api.OpenWeatherAPI
import com.doaa.data.utils.RemoteConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder(val okHttpBuilder: OkHttpBuilder) {

    val baseUrl =
        "${RemoteConstants.Base.BASE_URL}"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpBuilder.okHttpClientObject)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val openWeatherAPI: OpenWeatherAPI = getRetrofit().create(OpenWeatherAPI::class.java)
}
