package com.example.spaces_task.view.university

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spaces_task.data.model.UniversityResponseItem
import com.example.spaces_task.databinding.ItemUniversityBinding
import javax.inject.Inject

class UniversityAdapter @Inject constructor() : RecyclerView.Adapter<UniversityViewHolder>() {

    private var listOfUniversity: ArrayList<UniversityResponseItem> = ArrayList()
    var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val binding =
            ItemUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UniversityViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return listOfUniversity.size
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bind(listOfUniversity[position])
        holder.itemClickListener = itemClickListener
    }

    fun addAll(list: List<UniversityResponseItem>) {
        listOfUniversity.addAll(list)
    }

    interface ItemClickListener {
        fun onItemClick(universityResponseItem: UniversityResponseItem)
    }
}