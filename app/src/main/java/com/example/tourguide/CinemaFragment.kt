package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentCinemasBinding
import com.example.tourguide.databinding.FragmentFitnessCenterBinding
import com.example.tourguide.databinding.FragmentRestuarantsBinding

class CinemaFragment : Fragment() {

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
                getString(R.string.tsum_description)),
            Place(R.drawable.broadway, getString(R.string.broadway_title), getString(R.string.broadway_address), getString(
                R.string.broadway_time), getString(R.string.broadway_distance), getString(R.string.broadway_price),
                getString(R.string.broadway_description))
        )
        binding.recyclerViewCinemas.adapter = Adapter(list)
        return binding.root
    }

}
