package com.example.hackio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hackio.databinding.AftdataBinding

class Onadapter(val listener:Onlisten) :
    ListAdapter<ContestsItem, Onadapter.FoodPhotosViewHolder>(DiffCallback) {

    inner class FoodPhotosViewHolder(
        private var binding: AftdataBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(foodPhoto: ContestsItem) {
            binding.codes= foodPhoto
            binding.executePendingBindings()
            itemView.setOnClickListener{
                listener.onclicked(foodPhoto)
            }
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [MarsPhoto] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<ContestsItem>() {
        override fun areItemsTheSame(oldItem: ContestsItem, newItem: ContestsItem): Boolean {
            return oldItem.duration == newItem.duration
        }

        override fun areContentsTheSame(oldItem: ContestsItem, newItem: ContestsItem): Boolean {
            return oldItem.end_time== newItem.end_time
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodPhotosViewHolder {
        return FoodPhotosViewHolder(
            AftdataBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: FoodPhotosViewHolder, position: Int) {
        val foodPhoto = getItem(position)
        holder.bind(foodPhoto)
    }
}
interface Onlisten
{
    fun onclicked(hit:ContestsItem)
}