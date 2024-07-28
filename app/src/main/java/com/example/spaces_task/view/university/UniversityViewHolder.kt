package com.example.spaces_task.view.university

import androidx.recyclerview.widget.RecyclerView
import com.example.spaces_task.data.model.UniversityResponseItem
import com.example.spaces_task.databinding.ItemUniversityBinding

class UniversityViewHolder(private val binding: ItemUniversityBinding) :
    RecyclerView.ViewHolder(binding.root) {

    var itemClickListener: UniversityAdapter.ItemClickListener? = null
    fun bind(universityResponseItem: UniversityResponseItem) {
        binding.tvUniversityName.text = universityResponseItem.name ?: ""
        binding.tvUniversityState.text = universityResponseItem.stateProvince ?: ""

        binding.root.setOnClickListener {
            itemClickListener?.onItemClick(universityResponseItem)
        }
    }
}