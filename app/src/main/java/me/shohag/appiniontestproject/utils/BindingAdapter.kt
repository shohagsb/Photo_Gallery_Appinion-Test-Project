package me.shohag.appiniontestproject.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import me.shohag.appiniontestproject.R


@BindingAdapter("loadImg")
fun bindImg(imageView: ImageView, imgUrl :String?) {
    imgUrl?.let {
        Picasso.get()
            .load(it)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .into(imageView)
    }
}
