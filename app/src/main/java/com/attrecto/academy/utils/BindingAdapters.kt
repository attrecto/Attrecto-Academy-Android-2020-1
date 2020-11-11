package com.attrecto.academy.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.attrecto.academy.screen.main.MovieHeadlineAdapter
import com.bumptech.glide.Glide

@BindingAdapter("items")
fun RecyclerView.setItemsFromBinding(items: List<MovieHeadlineAdapter.ViewContent>?) {
    (this.adapter as? ListAdapter<MovieHeadlineAdapter.ViewContent, *>)?.submitList(items)
}

@BindingAdapter("image")
fun ImageView.setImage(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}
