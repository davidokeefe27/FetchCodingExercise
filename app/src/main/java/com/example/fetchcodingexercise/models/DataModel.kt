package com.example.fetchcodingexercise.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataModel (
    val id: Int,
    @Json(name = "listId")
    val listId: Int,
    val name: String?,
)