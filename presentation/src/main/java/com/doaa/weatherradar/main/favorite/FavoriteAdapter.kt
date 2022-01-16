/*
 *
 * Created by doaafouad on 1/16/22 11:56 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:56 PM
 *
 *
 */

package com.doaa.weatherradar.main.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doaa.domain.entities.FavoriteItemModel
import com.doaa.weatherradar.databinding.RowFavoriteBinding

class FavoriteAdapter(val favoriteListener: FavoriteListener) :
    RecyclerView.Adapter<FavoriteViewHolder>() {

    private var favoriteList: List<FavoriteItemModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemBinding =
            RowFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(itemBinding, favoriteListener)
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        return holder.initRow(favoriteList[position])
    }

    fun setData(favoriteData: List<FavoriteItemModel>?) {
        favoriteData?.let {
            favoriteList = favoriteData
        }
        notifyDataSetChanged()
    }
}