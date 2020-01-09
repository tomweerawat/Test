package com.example.ookbee.di

import com.example.architecturecomponent.data.network.builder.OkHttpBuilder
import com.example.architecturecomponent.data.network.builder.RetrofitBuilder
import com.example.ookbee.data.network.IBookApi
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://api.ookbee.com"

val networkModule = module {

    single { OkHttpBuilder().build() }

    single<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }

    single<Converter.Factory> { GsonConverterFactory.create() }

    single { RetrofitBuilder(get(), get(), get()) }

    single<IBookApi> { get<RetrofitBuilder>().build(BASE_URL) }
}