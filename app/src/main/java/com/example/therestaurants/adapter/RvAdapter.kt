package com.example.therestaurants.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.therestaurants.api.model.Restaurant
import com.example.therestaurants.api.model.RestaurantItem
import com.example.therestaurants.databinding.RowItemListRestaurantBinding

class RvAdapter(private val restaurantList: ArrayList<RestaurantItem>) :
    RecyclerView.Adapter<RvAdapter.RestaurantListViewHolder>() {

    lateinit var listener: OnItemClickListener

    inner class RestaurantListViewHolder(private val binding: RowItemListRestaurantBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: RestaurantItem) {
            with(binding) {
                data.apply {
                    Glide.with(itemView.context)
                        .load(data.pictureId)
                        .into(ivRestaurant)
                    tvName.text = name
                    tvLoc.text = city
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListViewHolder =
        RestaurantListViewHolder(
            RowItemListRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: RestaurantListViewHolder, position: Int) {
        holder.bind(restaurantList[position])
        holder.itemView.setOnClickListener { listener.onItemClicked(restaurantList[position]) }
    }

    override fun getItemCount(): Int = restaurantList.size

    interface OnItemClickListener {
        fun onItemClicked(item: RestaurantItem)
    }
}


