package com.attrecto.academy.screen.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.attrecto.academy.databinding.ViewMovieHeaderlineBinding

class MovieHeadlineAdapter(diffCallback: DiffUtil.ItemCallback<ViewContent> = DefaultItemCallback()) :
    ListAdapter<MovieHeadlineAdapter.ViewContent, MovieHeadlineAdapter.ViewHolder>(diffCallback) {

    class ViewContent(val title: String, val year: String, val onClick: () -> Unit)

    class ViewHolder(private val binding: ViewMovieHeaderlineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var viewContent: ViewContent?
            get() = binding.viewContent
            set(value) {
                binding.viewContent = value
            }
    }

    class DefaultItemCallback : DiffUtil.ItemCallback<ViewContent>() {
        override fun areItemsTheSame(oldItem: ViewContent, newItem: ViewContent): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: ViewContent, newItem: ViewContent): Boolean {
            return false
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ViewMovieHeaderlineBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewContent = getItem(position)
    }
}