package com.example.spaces_task.view.university

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.spaces_task.data.model.UniversityResponseItem
import com.example.spaces_task.databinding.FragmentUniversityListBinding
import com.example.spaces_task.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UniversityListFragment : BaseFragment<FragmentUniversityListBinding>() {

    @Inject
    lateinit var universityAdapter: UniversityAdapter

    override val bindingInflater: (LayoutInflater) -> FragmentUniversityListBinding
        get() = FragmentUniversityListBinding::inflate

    private val universityViewModel: UniversityViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        universityViewModel.getUniversity()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        universityViewModel.universityLivedata.observe(viewLifecycleOwner) { response ->
            response?.let {
                setAdapter(it)
            }
        }

        universityViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAdapter(universityList: List<UniversityResponseItem>) {
        universityAdapter.addAll(universityList)
        universityAdapter.itemClickListener = object : UniversityAdapter.ItemClickListener {
            override fun onItemClick(universityResponseItem: UniversityResponseItem) {
                val action =
                    UniversityListFragmentDirections.actionUniversityListFragmentToUniversityDetailsFragment(
                        extraUniversityDetails = universityResponseItem
                    )
            }

        }
        binding.rvUniversityList.adapter = universityAdapter
    }
}