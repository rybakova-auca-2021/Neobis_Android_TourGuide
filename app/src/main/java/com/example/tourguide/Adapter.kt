package com.example.tourguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
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
    }

    override fun getItemCount() = places.size

    inner class PlaceViewHolder(private val binding: CardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(place: Place) {
            with(binding) {
                Glide.with(placeImage).load(place.image).into(placeImage)
                placeName.text = place.title
                placeAddress.text = place.address
                placeTime.text = place.workingTime
                placeDistance.text = place.distance
                placePrice.text = place.price
                placeDescription.text = place.description

                placeAddress.setOnClickListener {
                    listener.openMap(place.address)
                }

                val isExpanded = place.isExpandable
                detailsLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE
                layout.setOnClickListener {
                    place.isExpandable = !isExpanded
                    notifyItemChanged(adapterPosition)
                }
            }
        }
    }

    interface Listener {
        fun openMap(location: String)
    }
}
