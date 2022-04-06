package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.data.model.Dogs
import com.example.myapplication.databinding.ListItemBinding
import javax.inject.Inject

class DogsAdapter @Inject constructor(): PagingDataAdapter<Dogs, DogsAdapter.DogsViewHolder>(Diff()) {


    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val dogs = getItem(position)
        if(dogs!= null){
            holder.binds(dogs)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder  =
        DogsViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    class DogsViewHolder(private val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun binds(dogs:Dogs){
            binding.apply {
                image.load(dogs.url)

            }
        }
    }

    class Diff : DiffUtil.ItemCallback<Dogs>(){
        override fun areItemsTheSame(oldItem: Dogs, newItem: Dogs): Boolean  =
            oldItem.url == newItem.url

        override fun areContentsTheSame(oldItem: Dogs, newItem: Dogs): Boolean =
            oldItem == newItem
    }
}