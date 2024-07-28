package com.example.spaces_task.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UniversityResponse(

    @field:SerializedName("Response")
    val response: List<UniversityResponseItem?>? = null
): Parcelable

@Parcelize
data class UniversityResponseItem(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("web_pages")
    val webPages: List<String?>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("domains")
    val domains: List<String?>? = null,

    @field:SerializedName("alpha_two_code")
    val alphaTwoCode: String? = null,

    @field:SerializedName("state-province")
    val stateProvince: String? = null
): Parcelable
