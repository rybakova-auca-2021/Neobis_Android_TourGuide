package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentFitnessCenterBinding
import com.example.tourguide.databinding.FragmentRestuarantsBinding

class FitnessCenterFragment : Fragment() {

    private lateinit var binding: FragmentFitnessCenterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFitnessCenterBinding.inflate(inflater, container, false)
        binding.recyclerViewFitnessCenter.layoutManager = LinearLayoutManager(requireContext())
        val list = arrayListOf(
            Place(R.drawable.dasmia, getString(R.string.dasmia_name), getString(R.string.dasmia_address),
                getString(R.string.dasmia_time), getString(R.string.dasmia_distance), getString(R.string.dasmia_price),
                getString(R.string.dasmia_description)),
            Place(R.drawable.world_class, getString(R.string.world_class_name), getString(R.string.world_class_address),
                getString(R.string.world_class_time), getString(R.string.world_class_distance), getString(R.string.world_class_price),
                getString(R.string.world_class_description))
        )
        binding.recyclerViewFitnessCenter.adapter = Adapter(list)
        return binding.root
    }

}
