package com.example.newsaggregator.mainscreen.model

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
