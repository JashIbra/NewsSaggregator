package com.newsaggregator.newsfeed.model

import com.newsaggregator.newsfeed.model.CreditModel
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import nl.adaptivity.xmlutil.serialization.XmlValue

@Serializable
@XmlSerialName("credit", "http://search.yahoo.com/mrss/", "media")
data class CreditDto (
    val scheme: String?,

    @XmlValue
    val value: String
)

fun CreditDto.toDomain(): CreditModel = CreditModel(
    scheme = scheme,
    value = value
)
