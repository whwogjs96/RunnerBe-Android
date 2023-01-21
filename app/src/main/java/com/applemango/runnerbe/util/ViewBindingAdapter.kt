package com.applemango.runnerbe.util

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.applemango.runnerbe.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageDrawable")
fun bindImageFromRes(view: ImageView, drawableId: Int) {
    view.setImageResource(drawableId)
}

@BindingAdapter("profileImageFromUrl")
fun bindProfileImageFromUrl(view: ImageView, url: String?) {
    if(url.isNullOrEmpty() || url =="null") {
        Glide.with(view.context)
            .load(R.drawable.ic_user_default)
            .into(view)
    } else {
        Glide.with(view.context)
            .load(url)
            .transform(CenterCrop(), RoundedCorners(200))
            .placeholder(R.drawable.ic_user_default)
            .error(R.drawable.ic_user_default)
            .into(view)
    }

}

@BindingAdapter("date_string")
fun bindDate(textView: TextView, dateString: String?) {
    if (dateString.isNullOrEmpty().not()) {
        textView.text = DateStringInT(dateString!!)
    }
}

@BindingAdapter("time_string")
fun bindTime(textView: TextView, dateString: String?) {
    if (dateString.isNullOrEmpty().not()) {
        textView.text = TimeString(dateString!!)
    }
}

@BindingAdapter("image_from_url_rounded")
fun bindImageFromURLRounded(imageView: ImageView, imageURL: String?) {
    if(imageURL.isNullOrEmpty()) {
        Glide.with(imageView.context)
            .load(R.drawable.ic_user_default)
            .into(imageView)
    } else {
        Glide.with(imageView.context)
            .load(imageURL)
            .error(R.drawable.ic_user_default)
            .transform(CenterCrop(), RoundedCorners(50))
            .into(imageView)
    }

}