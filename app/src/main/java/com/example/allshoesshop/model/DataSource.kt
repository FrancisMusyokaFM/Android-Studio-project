package com.example.allshoesshop.model

import com.example.allshoesshop.R
import com.example.allshoesshop.data.CartType

class DataSource() {
    fun loadCartItems():List<CartType>{
        return listOf<CartType>(
            CartType(R.string.name,R.drawable.men1),
            CartType(R.string.daaaaaa,R.drawable.men2),
            CartType(R.string.deee,R.drawable.men3),
            CartType(R.string.dod,R.drawable.men5),
            CartType(R.string.dod,R.drawable.women1),
            CartType(R.string.dod,R.drawable.women2),
            CartType(R.string.dod,R.drawable.women3),
            CartType(R.string.dod,R.drawable.women4),
            CartType(R.string.dod,R.drawable.women15),
        )
    }
}