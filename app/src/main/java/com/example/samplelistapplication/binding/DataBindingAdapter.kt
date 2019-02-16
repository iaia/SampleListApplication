package com.example.samplelistapplication.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindingAdapters {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageResource(view: ImageView, resource: Int) {
        view.setImageResource(resource)
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageDrawable(view: ImageView, drawable: Drawable) {
        view.setImageDrawable(drawable)
    }
}
