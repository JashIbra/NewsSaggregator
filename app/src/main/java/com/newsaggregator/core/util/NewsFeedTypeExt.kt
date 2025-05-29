package com.newsaggregator.core.util

import com.newsaggregator.R
import com.newsaggregator.newsfeed.model.NewsFeedType

val NewsFeedType.titleRes
    get() = when (this) {
        NewsFeedType.News -> R.string.news_tab_news
        NewsFeedType.Opinion -> R.string.news_tab_opinion
        NewsFeedType.Sport -> R.string.news_tab_sport
        NewsFeedType.Culture -> R.string.news_tab_culture
        NewsFeedType.Lifestyle -> R.string.news_tab_lifestyle
    }
