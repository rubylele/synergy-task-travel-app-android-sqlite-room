package com.example.task1synergy.fragments.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_city_list.view.*
import com.example.task1synergy.R


class CityListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewCityList =  inflater.inflate(R.layout.fragment_city_list, container, false)

        viewCityList.addFloatingButton.setOnClickListener {
            findNavController().navigate(R.id.action_cityListFragment_to_addCityFragment)
        }
        viewCityList.listCityWithLandmarkButton.setOnClickListener {
            findNavController().navigate(R.id.action_addCityFragment_to_cityListFragment)
        }

        return viewCityList
    }


}