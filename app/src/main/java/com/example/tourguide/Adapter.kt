package com.example.tourguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tourguide.databinding.CardBinding


class Adapter(private val dataSet: ArrayList<Place>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CardBinding.bind(view)
        fun bind(place: Place) = with(binding) {
            Glide.with(binding.placeImage).load(place.image).into(binding.placeImage)
            placeName.text = place.title
            placeAddress.text = place.address
            placeTime.text = place.workingTime
            placeDistance.text = place.distance
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.bind(item)
    }
    override fun getItemCount() = dataSet.size
}
