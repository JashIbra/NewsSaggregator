package com.newsaggregator.newsfeed.model

import com.newsaggregator.newsfeed.model.CategoryModel
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import nl.adaptivity.xmlutil.serialization.XmlValue

@Serializable
@XmlSerialName("category")
data class CategoryDto(

    val domain: String,

    @XmlValue
    val value: String
)

fun CategoryDto.toDomain(): CategoryModel = CategoryModel(
    domain = domain,
    value = value
)