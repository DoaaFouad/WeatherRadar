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

import androidx.recyclerview.widget.RecyclerView
import com.doaa.domain.entities.FavoriteItemModel
import com.doaa.weatherradar.R
import com.doaa.weatherradar.databinding.RowFavoriteBinding

class FavoriteViewHolder(
    val rowBinding: RowFavoriteBinding,
    val listener: FavoriteListener
) :
    RecyclerView.ViewHolder(rowBinding.root) {

    fun initRow(model: FavoriteItemModel) {
        rowBinding.tvCity.text = model.city
        rowBinding.tvCityTemperature.text = "${model.lastTemperature} ${
            model.unit
        }"

        rowBinding.root.setOnClickListener {
            listener.onItemClicked(model.lat, model.lng)
        }
    }
}
