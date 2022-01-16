/*
 *
 * Created by doaafouad on 1/16/22 3:45 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:43 PM
 *
 *
 */

package com.doaa.data.repositories

import com.doaa.data.remote.model.BaseResponse
import com.doaa.data.remote.model.RemoteModel
import com.doaa.domain.common.BaseDataSource
import com.doaa.domain.entities.ItemModel
import kotlinx.coroutines.Dispatchers

abstract class BaseRespository {

    protected var dispatcherIO = Dispatchers.IO

    protected fun <R : RemoteModel, T : ItemModel> mapToDataSource(
        remoteBaseResponse: BaseResponse<R>,
        dataItemModel: T
    ): BaseDataSource<T> {
        return BaseDataSource(
            responseCode = remoteBaseResponse.responseCode?:0,
            message = remoteBaseResponse.message?:"",
            data = dataItemModel
        )

    }
}