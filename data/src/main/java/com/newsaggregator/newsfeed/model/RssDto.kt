package com.newsaggregator.newsfeed.model

import com.newsaggregator.newsfeed.model.RssModel
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("rss")
data class RssDto (
    val version: String,
    @XmlElement
    val channel: ChannelDto
)

fun RssDto.toDomain(): RssModel = RssModel(
    version = version,
    channel = channel.toDomain()
)
