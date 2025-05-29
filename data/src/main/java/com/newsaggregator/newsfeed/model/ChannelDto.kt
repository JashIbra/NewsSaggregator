package com.newsaggregator.newsfeed.model

import com.newsaggregator.newsfeed.model.ChannelModel
import com.newsaggregator.newsfeed.model.ItemModel
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("channel")
data class ChannelDto(
    @XmlSerialName("title")
    @XmlElement(true)
    val title: String,

    @XmlSerialName("link")
    @XmlElement(true)
    val link: String,

    @XmlSerialName("description")
    @XmlElement(true)
    val description: String,

    @XmlSerialName("language")
    @XmlElement(true)
    val language: String,

    @XmlSerialName("copyright")
    @XmlElement(true)
    val copyright: String,

    @XmlSerialName("pubDate")
    @XmlElement(true)
    val pubDate: String,

    @XmlSerialName("date", "http://purl.org/dc/elements/1.1/", "dc")
    @XmlElement(true)
    val dcDate: String,

    @XmlSerialName("language", "http://purl.org/dc/elements/1.1/", "dc")
    @XmlElement(true)
    val dcLanguage: String,

    @XmlSerialName("rights", "http://purl.org/dc/elements/1.1/", "dc")
    @XmlElement(true)
    val dcRights: String,

    val image: ImageDto,

    val items: List<ItemDto>,
)

fun ChannelDto.toDomain() : ChannelModel = ChannelModel(
    title = title,
    link = link,
    description = description,
    language = language,
    copyright = copyright,
    pubDate = pubDate,
    dcDate = dcDate,
    dcLanguage = dcLanguage,
    dcRights = dcRights,
    image = image.toDomain(),
    items = items.toDomain(),
)

fun List<ItemDto>.toDomain(): List<ItemModel> = map (ItemDto::toDomain)
