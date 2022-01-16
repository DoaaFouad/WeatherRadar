/*
 *
 * Created by doaafouad on 1/16/22 10:16 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 10:16 PM
 *
 *
 */

package com.doaa.data.cache.room.favorite

import androidx.room.*

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM Favorite")
    fun get(): List<Favorite>

    @Insert
    fun add(vararg user: Favorite)

    @Delete
    fun delete(user: Favorite)
}