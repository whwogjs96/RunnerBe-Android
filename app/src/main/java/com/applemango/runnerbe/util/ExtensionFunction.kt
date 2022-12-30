package com.applemango.runnerbe.util

import android.content.Context
import android.util.TypedValue
import android.widget.ImageView

fun ImageView.imageSrcCompatResource(resourceId: Int) {
    setImageResource(resourceId)
}

fun Int.dpToPx(context: Context): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics).toInt()
}