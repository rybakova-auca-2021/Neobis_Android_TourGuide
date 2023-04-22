package com.example.tourguide

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourguide.databinding.FragmentRestuarantsBinding

class RestaurantFragment : Fragment(), Adapter.Listener {

    private lateinit var binding: FragmentRestuarantsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRestuarantsBinding.inflate(inflater, container, false)
        binding.recyclerViewRestaurant.layoutManager = LinearLayoutManager(requireContext())
        val list = arrayListOf(
            Place(R.drawable.silla_img, getString(R.string.silla_name), getString(R.string.silla_address), getString(R.string.silla_time), getString(R.string.silla_distance), getString(R.string.silla_price), getString(R.string.silla_description), "70000001020099949"),
            Place(R.drawable.zerno_img, getString(R.string.zerno_name), getString(R.string.zerno_address), getString(R.string.zerno_time), getString(R.string.zerno_distance), getString(R.string.zerno_price), getString(R.string.zerno_description), "70000001057692093"),
            Place(R.drawable.turkuaz_img, getString(R.string.turkuaz_name), getString(R.string.turkuaz_address), getString(R.string.turkuaz_time), getString(R.string.turkuaz_distance), getString(R.string.turkuaz_price), getString(R.string.turkuaz_description), "70000001063233370"),
            Place(R.drawable.bruno, getString(R.string.bruno_name), getString(R.string.bruno_address), getString(R.string.bruno_time), getString(R.string.bruno_distance), getString(R.string.bruno_price), getString(R.string.bruno_description), "70000001042522057"),
            Place(R.drawable.iwa_img, getString(R.string.iwa_name), getString(R.string.iwa_address), getString(R.string.iwa_time), getString(R.string.iwa_distance), getString(R.string.iwa_price), getString(R.string.iwa_description), "70000001042571832")
        )
        binding.recyclerViewRestaurant.adapter = Adapter(list, this)
        return binding.root
    }
    override fun openMap(location: String) {
        try {
            val uri = Uri.parse("geo: $location")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri).apply { setPackage("com.google.android.apps.maps") }
            startActivity(mapIntent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(activity, "Map is not installed", Toast.LENGTH_SHORT)
        }
    }
}
