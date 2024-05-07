package com.example.musicianapplication.ui.musician

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicianapplication.R
import com.example.musicianapplication.databinding.ItemMusicianBinding
import com.example.musicianapplication.domain.remotemodel.Musician.MusicianItemRemoteModel

class MusicianAdapter : ListAdapter<MusicianItemRemoteModel, MusicianAdapter.MusicianViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicianViewHolder {
        val binding = ItemMusicianBinding.inflate(LayoutInflater.from(parent.context))
        return MusicianViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicianViewHolder, position: Int) {
        holder.bing(getItem(position))
    }

    class MusicianViewHolder(private val binding: ItemMusicianBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bing(item: MusicianItemRemoteModel) {
            binding.textViewName.text = item.artistName
            Glide.with(binding.imageViewMusician.context)
                .load(item.artworkUrl100)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageViewMusician)
        }
    }

    companion object{
        private val DiffCallBack = object : DiffUtil.ItemCallback<MusicianItemRemoteModel>(){
            override fun areItemsTheSame(
                oldItem: MusicianItemRemoteModel,
                newItem: MusicianItemRemoteModel
            ) = oldItem.isStreamable == newItem.isStreamable

            override fun areContentsTheSame(
                oldItem: MusicianItemRemoteModel,
                newItem: MusicianItemRemoteModel
            ) = oldItem == newItem
        }
    }


}