package com.example.spaces_task.view.university

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.spaces_task.data.model.UniversityResponseItem
import com.example.spaces_task.databinding.FragmentUniversityDetailsBinding
import com.example.spaces_task.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UniversityDetailsFragment : BaseFragment<FragmentUniversityDetailsBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentUniversityDetailsBinding
        get() = FragmentUniversityDetailsBinding::inflate

    private val args: UniversityDetailsFragmentArgs by navArgs()

    private val universityDetails: UniversityResponseItem? by lazy {
        args.extraUniversityDetails
    }

    private val universityViewModel: UniversityViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        binding.imgRefresh.setOnClickListener() {
            Toast.makeText(requireContext(), "Refresh", Toast.LENGTH_SHORT).show()
            universityViewModel.getUniversity()
        }
    }

    private fun initializeUI() {
        universityDetails?.let {
            with(binding) {
                tvUniversityName.text = it.name
                tvUniversityState.text = it.stateProvince
                tvCountry.text = it.country
                tvWebPage.text = it.webPages.toString()
                tvCountryCode.text = it.alphaTwoCode
            }
        }
    }
}