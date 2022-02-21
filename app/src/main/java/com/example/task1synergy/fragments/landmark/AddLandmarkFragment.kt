package com.example.task1synergy.fragments.landmark

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_add_landmark.*
import kotlinx.android.synthetic.main.fragment_add_landmark.view.addLandmarkButton
import com.example.task1synergy.R
import com.example.task1synergy.data.CityViewModel
import com.example.task1synergy.data.Landmark
import com.example.task1synergy.data.LandmarkViewModel


class AddLandmarkFragment : Fragment() {

    private lateinit var mLandmarkViewModel: LandmarkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val addLandmarkView = inflater.inflate(R.layout.fragment_add_landmark, container, false)
        mLandmarkViewModel = ViewModelProvider(this)[LandmarkViewModel::class.java]

        addLandmarkView.addLandmarkButton.setOnClickListener {
            insertDataToDatabase()
        }


        return addLandmarkButton
    }

    private fun insertDataToDatabase() {
        val landmarkName = landmarkNameEditText.text.toString()
        val landmarkDescription = landmarkDescriptionEditText.text.toString()

        if(inputCheck(landmarkName, landmarkDescription)) {
            //Create City Object
            val landmark = Landmark(0, 0, landmarkName, landmarkDescription)
            //Add Data To Database
            mLandmarkViewModel.addLandmark(landmark)
        }else{
            Toast.makeText(requireContext(), "Some empty fills here.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(landmarkName: String, landmarkDescription: String): Boolean {
        return !(TextUtils.isEmpty(landmarkName) && TextUtils.isEmpty(landmarkDescription))
    }

}
