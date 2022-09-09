package com.deyber.movie._utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.deyber.movie._utils.constants.RetrofitConstants


fun ImageView.typeProfile(src:String){
    Glide
        .with(this)
        .load(src)
        .centerCrop()
        .circleCrop()
        .into(this)
}

fun ImageView.typePoster(src: String){
    Glide
        .with(this)
        .load(src)
        .centerCrop()
        .into(this)
}