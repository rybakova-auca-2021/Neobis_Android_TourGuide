package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tourguide.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val place = arguments?.getParcelable<Place>("place")
        Glide.with(binding.image).load(place?.image).into(binding.image)
        binding.apply {
            detailTitle.text = place?.title
            detailAddress.text = place?.address
            detailWorkingTime.text = place?.workingTime
            detailDistance.text = place?.distance
            detailAverageCheck.text = place?.averageCheck
            detailDescription.text = place?.description
            detailAdditionalInformation.text = place?.additionalInformation
        }
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.navigateToMainFragment)
        }
    }
}