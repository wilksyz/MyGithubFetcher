package com.antoine.mygithubfetcher.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class AvatarContributor {

    var imageUrl: String = ""

    companion object{
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, imageUrl: String){
            Glide.with(view.context)
                .load(imageUrl)
                .circleCrop()
                .into(view)
        }
    }
}