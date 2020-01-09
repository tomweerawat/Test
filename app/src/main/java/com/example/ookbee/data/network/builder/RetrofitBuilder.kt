package com.example.architecturecomponent.data.network.builder

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder(
    val okHttpClient: OkHttpClient,
    val converterFactory: Converter.Factory,
    val adapterFactory: CallAdapter.Factory
) {

    inline fun <reified T> build(baseUrl: String): T {

        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .setPrettyPrinting()
            .create()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(adapterFactory)
            .build()
            .create(T::class.java)
    }
}