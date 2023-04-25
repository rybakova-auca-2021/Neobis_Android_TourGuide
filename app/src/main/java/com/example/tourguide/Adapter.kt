package com.example.tourguide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tourguide.databinding.CardBinding


class Adapter(
    private val places: List<Place>,
    private val listener: Listener
) : RecyclerView.Adapter<Adapter.PlaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardBinding.inflate(inflater, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place)
        holder.binding.layout.setOnClickListener {
            listener.navigateToFragment(place)
        }
    }

    override fun getItemCount() = places.size

    inner class PlaceViewHolder(val binding: CardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(place: Place) {
            with(binding) {
                Glide.with(placeImage).load(place.image).into(placeImage)
                placeName.text = place.title
                placeAddress.text = place.address
                placeTime.text = place.workingTime
                placeDistance.text = place.distance
                placePrice.text = place.averageCheck
                placeDescription.text = place.description

                placeAddress.setOnClickListener {
                    place.address?.let { it1 -> listener.openMap(it1) }
                }
            }
        }
    }

    interface Listener {
        fun openMap(location: String)
        fun navigateToFragment(place: Place)
    }
}
