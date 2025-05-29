package com.newsaggregator.newsfeed.model

import com.newsaggregator.newsfeed.model.ContentModel
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("content", "http://search.yahoo.com/mrss/", "media")
data class ContentDto (
    val type: String?,
    val width: String?,
    val url: String,
    val credit: CreditDto?,

    @XmlElement(true)
    val description: String?
)

fun ContentDto.toDomain(): ContentModel = ContentModel(
    type = type,
    width = width,
    url = url,
    credit = credit?.toDomain()
)
