package com.example.musicianapplication.ui.musician

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicianapplication.R
import com.example.musicianapplication.databinding.ItemMusicianBinding
import com.example.musicianapplication.domain.remotemodel.Musician.MusicianItemResponseModel

class MusicianAdapter : ListAdapter<MusicianItemResponseModel, MusicianAdapter.MusicianViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicianViewHolder {
        val binding = ItemMusicianBinding.inflate(LayoutInflater.from(parent.context))
        return MusicianViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicianViewHolder, position: Int) {
        holder.bing(getItem(position))
    }

    class MusicianViewHolder(private val binding: ItemMusicianBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bing(item: MusicianItemResponseModel) {
            binding.textViewName.text = item.artistName
            Glide.with(binding.imageViewMusician.context)
                .load(item.artworkUrl100)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageViewMusician)
        }
    }

    companion object{
        private val DiffCallBack = object : DiffUtil.ItemCallback<MusicianItemResponseModel>(){
            override fun areItemsTheSame(
                oldItem: MusicianItemResponseModel,
                newItem: MusicianItemResponseModel
            ) = oldItem.isStreamable == newItem.isStreamable

            override fun areContentsTheSame(
                oldItem: MusicianItemResponseModel,
                newItem: MusicianItemResponseModel
            ) = oldItem == newItem
        }
    }


}