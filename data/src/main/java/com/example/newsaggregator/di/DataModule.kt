package com.example.newsaggregator.di

import com.example.newsaggregator.api.RssFeed
import com.example.newsaggregator.mainscreen.repository.MainRepositoryImpl
import com.example.newsaggregator.mainscreen.repository.MainRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun dataModule() = module {

    single { getRetrofit().create(RssFeed::class.java) }
    singleOf(::MainRepositoryImpl) bind MainRepository::class

}