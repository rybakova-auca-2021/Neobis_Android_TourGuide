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
import com.example.tourguide.databinding.FragmentCinemasBinding

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
                getString(R.string.tsum_description), getString(R.string.cinema_tsum),getString(R.string.tsum_location), getString(
                                    R.string.tsum_conatct)),
            Place(R.drawable.broadway, getString(R.string.broadway_title), getString(R.string.broadway_address), getString(
                R.string.broadway_time), getString(R.string.broadway_distance), getString(R.string.broadway_price),
                getString(R.string.broadway_description), getString(R.string.cinema_broadway),getString(
                                    R.string.broadway_location), getString(R.string.broadway_contact))
        )
        binding.recyclerViewCinemas.adapter = Adapter(list, this)
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
