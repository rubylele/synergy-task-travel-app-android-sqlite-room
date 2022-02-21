package com.example.task1synergy.fragments.city

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.task1synergy.model.City
import com.example.task1synergy.model.CityViewModel
import kotlinx.android.synthetic.main.fragment_add_city.*
import kotlinx.android.synthetic.main.fragment_add_city.view.addCityButton
import com.example.task1synergy.R



class AddCityFragment : Fragment() {

    private lateinit var mCityViewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val addCityView = inflater.inflate(R.layout.fragment_add_city, container, false)

        mCityViewModel = ViewModelProvider(this)[CityViewModel::class.java]

        addCityView.addCityButton.setOnClickListener {
            insertDataToDatabase()
        }


        return addCityView
    }

    private fun insertDataToDatabase() {
        val cityName = cityNameEditText.text.toString()
        val cityDescription = cityDescriptionEditText.text.toString()
        val cityAge = cityAgeEditText.text

        if(inputCheck(cityName, cityDescription, cityAge)) {
            //Create City Object
            val city = City(0, cityName, cityDescription, Integer.parseInt(cityAge.toString()))
            //Add Data To Database
            mCityViewModel.addCity(city)
        }else{
            Toast.makeText(requireContext(), "Some empty fills here.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(cityName: String, cityDescription: String, cityAge: Editable): Boolean {
        return !(TextUtils.isEmpty(cityName) && TextUtils.isEmpty(cityDescription) && cityAge.isEmpty())
    }

}