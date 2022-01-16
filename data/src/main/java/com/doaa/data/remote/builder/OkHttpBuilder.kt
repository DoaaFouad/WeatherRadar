/*
 *
 * Created by doaafouad on 1/16/22 12:11 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 12:11 PM
 *
 *
 */

package com.doaa.data.remote.builder

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkHttpBuilder() {

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createLogInterceptor())
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    private fun createLogInterceptor(): HttpLoggingInterceptor {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        logInterceptor as Interceptor

        return logInterceptor
    }

    val okHttpClientObject: OkHttpClient = getOkHttpClient()
}