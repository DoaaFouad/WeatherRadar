/*
 *
 * Created by doaafouad on 1/16/22 11:36 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:35 AM
 *
 *
 */

object BuildConfigs {
    const val APPLICATION_ID = "com.doaa.weatherradar"

    const val COMPILE_SDK = 31
    const val MIN_SDK = 24
    const val TARGET_SDK = 31
    const val BUILD_TOOLS_VERSION = "29.0.3"

    const val DEVELOPMENT_VERSION_CODE = 1
    const val DEVELOPMENT_VERSION_NAME = "1.0"
}

object Versions {
    // Kotlin
    const val KOTLIN = "1.3.72"

    // Google play services
    const val PLAY_SERVICES_LOCATION = "19.0.1"

    // UI
    const val ANDROID_X = "1.3.2"
    const val APPCOMPAT = "1.3.1"
    const val MATERIAL = "1.5.0-alpha03"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val GLIDE = "4.11.0"

    // Architecture Component
    const val ARCH_COMPONENT = "2.2.0"
    const val ARCH_COMPONENT_LIFECYCLE = "2.3.1"

    // DI
    const val KOIN = "2.0.1"
    const val KOIN_ANDROID = "2.0.1"

    // Asynchronous
    const val COROUTINES_CORE = "1.4.3"
    const val COROUTINES_ANDROID = "1.4.0"

    const val ANDROIDX_SECURITY = "1.1.0-alpha03"

    // Networking
    const val RETROFIT = "2.7.1"
    const val RETROFIT_CONVERTOR = "2.6.2"
    const val RETROFIT_RXJAVA = "2.6.2"
    const val OKHTTP = "3.12.1"

    //Data
    const val ROOM = "2.2.6"
    
    // Parsing
    const val GSON = "2.8.6"

    // Memory utils
    const val LEAK_CANARY = "2.6"

}

object Libraries {

    // Kotlin
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    // Google play services
    const val PLAY_SERVICES_LOCATION = "com.google.android.gms:play-services-location:${Versions.PLAY_SERVICES_LOCATION}"
    // UI
    const val ANDROID_X = "androidx.core:core-ktx:${Versions.ANDROID_X}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"

    // Architecture Components
    const val ARCH_COMPONENT =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ARCH_COMPONENT}"
    const val ARCH_COMPONENT_LIFECYCLE =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ARCH_COMPONENT_LIFECYCLE}"

    // DI
    const val KOIN = "org.koin:koin-core:${Versions.KOIN}"
    const val KOIN_ANDROID = "org.koin:koin-androidx-viewmodel:${Versions.KOIN_ANDROID}"

    // Asynchronous
    const val COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_CORE}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID}"

    // Cryptography
    const val ANDROIDX_SECURITY = "androidx.security:security-crypto:${Versions.ANDROIDX_SECURITY}"

    // Networking
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTOR =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_CONVERTOR}"
    const val RETROFIT_RXJAVA = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT_RXJAVA}"
    const val OKHTTP = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    // Data
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"

    // Memory utils
    const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:${Versions.LEAK_CANARY}"

}
