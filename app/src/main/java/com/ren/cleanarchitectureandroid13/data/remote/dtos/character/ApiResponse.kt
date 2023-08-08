package com.ren.cleanarchitectureandroid13.data.remote.dtos.character

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("info")
    val info: Info
)