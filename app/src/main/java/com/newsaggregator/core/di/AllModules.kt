package com.newsaggregator.core.di

import com.newsaggregator.di.dataModule
import com.newsaggregator.di.networkModule
import com.newsaggregator.newsfeed.di.newsFeedDomainModule
import com.newsaggregator.newsfeed.presentationModule
import org.koin.dsl.module

fun allModules() = module {
    includes(
        dataModule(),
        newsFeedDomainModule(),
        networkModule(),
        presentationModule()
    )
}
