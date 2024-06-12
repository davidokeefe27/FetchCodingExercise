package com.example.fetchcodingexercise.name

import com.example.fetchcodingexercise.models.DataModel

data class DataUIModel (
    val listId: Int,
    val name: String?,
)

fun dataToDataUI(data: DataModel): DataUIModel {
    return DataUIModel(
        listId = data.listId,
        name = data.name
    )
}