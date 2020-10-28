package com.attrecto.academy.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.attrecto.academy.screen.main.MovieHeadlineAdapter

@BindingAdapter("items")
fun RecyclerView.setItemsFromBinding(items: List<MovieHeadlineAdapter.ViewContent>?) {
    (this.adapter as? ListAdapter<MovieHeadlineAdapter.ViewContent, *>)?.submitList(items)
}
