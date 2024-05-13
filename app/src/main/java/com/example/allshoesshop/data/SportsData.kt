package com.example.allshoesshop.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SportsData(
    @StringRes
    val stringResourceId : Int,
    @DrawableRes
    val drawableResourceId : Int
)
