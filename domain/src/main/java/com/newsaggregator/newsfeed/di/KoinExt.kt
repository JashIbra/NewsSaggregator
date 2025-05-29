package com.newsaggregator.newsfeed.di

import org.koin.java.KoinJavaComponent

inline fun <reified T> genInject(): Lazy<T> {
    return lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        KoinJavaComponent.get(T::class.java)
    }
}
