/*
 * Created by Doaa Fouad on 4/19/21 2:08 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 *
 * Last modified 4/19/21 2:08 AM
 */

package com.emc.voicenote.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.doaa.data.cache.room.favorite.Favorite
import com.doaa.data.cache.room.favorite.FavoriteDao

@Database(entities = arrayOf(Favorite::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}