package com.newsaggregator.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.get
import retrofit2.Retrofit

fun getRetrofit(): Retrofit = get(Retrofit::class.java)

fun networkModule () = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.theguardian.com")
            .addConverterFactory(
                XML.asConverterFactory(
                    MediaType.get("application/xml; charset=UTF8")
                )
            ).build()
    }
}
