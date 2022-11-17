package com.salim.bitaqwa.menus.videokajian.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class VideoKajianModel (
    var thumbnail : Int = 0,
    var channel : String = "",
    var speaker : String = "",
    var title : String = "",
    var urlVideo : String = "",
    var summary : String = ""
        ) : Parcelable