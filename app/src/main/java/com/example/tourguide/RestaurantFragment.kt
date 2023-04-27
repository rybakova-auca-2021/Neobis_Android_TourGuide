package com.example.tourguide

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.R.*
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
            Place(drawable.silla_img, getString(string.silla_name), getString(string.silla_address), getString(
                    string.silla_time), getString(string.silla_distance), getString(string.silla_price), getString(
                    string.silla_description), getString(string.silla_info) ,getString(string.silla_location), getString(
                                    string.silla_contaact)),
            Place(drawable.zerno_img, getString(string.zerno_name), getString(string.zerno_address), getString(
                    string.zerno_time), getString(string.zerno_distance), getString(string.zerno_price), getString(
                    string.zerno_description), getString(string.zerno_info),getString(string.zerno_location), getString(
                                    string.zerno_contact)),
            Place(drawable.turkuaz_img, getString(string.turkuaz_name), getString(string.turkuaz_address), getString(
                    string.turkuaz_time), getString(string.turkuaz_distance), getString(string.turkuaz_price), getString(
                    string.turkuaz_description), getString(string.turkuaz_info),getString(string.turkuaz_location), getString(
                                    string.turkuaz_contact)),
            Place(drawable.bruno, getString(string.bruno_name), getString(string.bruno_address), getString(
                    string.bruno_time), getString(string.bruno_distance), getString(string.bruno_price), getString(
                    string.bruno_description), getString(string.bruno_info),getString(string.bruno_location), getString(
                                    string.bruno_contact)),
            Place(drawable.iwa_img, getString(string.iwa_name), getString(string.iwa_address), getString(
                    string.iwa_time), getString(string.iwa_distance), getString(string.iwa_price), getString(
                    string.iwa_description), getString(string.iwa_info),getString(string.iwa_location), getString(
                                    string.iwa_contact))
        )
        binding.recyclerViewRestaurant.adapter = Adapter(list, this)
        return binding.root
    }
    override fun openMap(location: String) {
        try {
            val uri = Uri.parse("geo: $location")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(Intent.createChooser(mapIntent, "Choose app"))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(activity, "Map is not installed", Toast.LENGTH_SHORT)
        }
    }

    override fun navigateToFragment(place: Place) {
        val bundle = Bundle()
        bundle.putParcelable("place", place)
        findNavController().navigate(R.id.navigateToDetailFragment, bundle)
    }

}
