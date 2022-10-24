package com.salim.bitaqwa.dashboard.data

import com.salim.bitaqwa.R
import com.salim.bitaqwa.dashboard.model.InspirationModel

object InspirationData {
    private val inpirationImage = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.inspiration_1,
        R.drawable.inspiration_3,
        R.drawable.inspiration_2,
        R.drawable.flayer_2
    )
    val listData : ArrayList<InspirationModel>
    get() {
        val list = arrayListOf<InspirationModel>()
        for (position in inpirationImage.indices){
            val inspiration = InspirationModel()
            inspiration.inspirationImage = inpirationImage[position]
            list.add(inspiration)
        }
        return list
    }
}