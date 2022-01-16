/*
 *
 * Created by doaafouad on 1/16/22 3:48 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:48 PM
 *
 *
 */

package com.doaa.domain.common
import com.doaa.domain.entities.ItemModel

data class BaseDataSource<T>(
    val responseCode: Int?,
    val message: String?,
    val data: T?
) : ItemModel
