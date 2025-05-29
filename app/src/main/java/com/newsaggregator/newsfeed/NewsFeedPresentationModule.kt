package com.newsaggregator.newsfeed

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun presentationModule () = module {
    viewModelOf(::NewsFeedViewModel)
}
