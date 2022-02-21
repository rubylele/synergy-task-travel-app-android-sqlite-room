package com.example.task1synergy.fragments.landmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.task1synergy.R
import kotlinx.android.synthetic.main.fragment_city_with_landmark.view.*


class CityWithLandmarkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewCityWithLandmarkList = inflater.inflate(R.layout.fragment_city_with_landmark, container, false)



        viewCityWithLandmarkList.addLandmarkFloatingButton.setOnClickListener {
            findNavController().navigate(R.id.action_landmarkFragment_to_addLandmarkFragment)
        }

        return viewCityWithLandmarkList
    }
}