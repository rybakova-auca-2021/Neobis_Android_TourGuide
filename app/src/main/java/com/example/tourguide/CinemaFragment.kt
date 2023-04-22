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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentCinemasBinding
import com.example.tourguide.databinding.FragmentFitnessCenterBinding
import com.example.tourguide.databinding.FragmentRestuarantsBinding

class CinemaFragment : Fragment(), Adapter.Listener {

    private lateinit var binding: FragmentCinemasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCinemasBinding.inflate(inflater, container, false)
        binding.recyclerViewCinemas.layoutManager = LinearLayoutManager(requireContext())
        val list = arrayListOf(
            Place(R.drawable.tsum, getString(R.string.tsum_title), getString(R.string.tsum_address), getString(
                R.string.tsum_time), getString(R.string.tsum_distance), getString(R.string.tsum_price),
                getString(R.string.tsum_description), "70000001040950307"),
            Place(R.drawable.broadway, getString(R.string.broadway_title), getString(R.string.broadway_address), getString(
                R.string.broadway_time), getString(R.string.broadway_distance), getString(R.string.broadway_price),
                getString(R.string.broadway_description), "70000001029043839")
        )
        binding.recyclerViewCinemas.adapter = Adapter(list, this)
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
