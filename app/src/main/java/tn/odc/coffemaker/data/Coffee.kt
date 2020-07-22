package tn.odc.coffemaker.data

import androidx.annotation.DrawableRes

data class Coffee(
        val title: String,
        @DrawableRes var image: Int
)