package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentRestuarantsBinding

class RestaurantFragment : Fragment() {

    private lateinit var binding: FragmentRestuarantsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRestuarantsBinding.inflate(inflater, container, false)
        binding.recyclerViewRestaurant.layoutManager = LinearLayoutManager(requireContext())
        val list = arrayListOf(
            Place(R.drawable.silla_img, getString(R.string.silla_name), getString(R.string.silla_address), getString(R.string.silla_time), getString(R.string.silla_distance), getString(R.string.silla_price), getString(R.string.silla_description)),
            Place(R.drawable.zerno_img, getString(R.string.zerno_name), getString(R.string.zerno_address), getString(R.string.zerno_time), getString(R.string.zerno_distance), getString(R.string.zerno_price), getString(R.string.zerno_description)),
            Place(R.drawable.turkuaz_img, getString(R.string.turkuaz_name), getString(R.string.turkuaz_address), getString(R.string.turkuaz_time), getString(R.string.turkuaz_distance), getString(R.string.turkuaz_price), getString(R.string.turkuaz_description)),
            Place(R.drawable.bruno, getString(R.string.bruno_name), getString(R.string.bruno_address), getString(R.string.bruno_time), getString(R.string.bruno_distance), getString(R.string.bruno_price), getString(R.string.bruno_description)),
            Place(R.drawable.iwa_img, getString(R.string.iwa_name), getString(R.string.iwa_address), getString(R.string.iwa_time), getString(R.string.iwa_distance), getString(R.string.iwa_price), getString(R.string.iwa_description))
        )
        binding.recyclerViewRestaurant.adapter = Adapter(list)
        return binding.root
    }

}
