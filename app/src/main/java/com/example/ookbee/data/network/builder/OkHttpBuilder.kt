package com.example.architecturecomponent.data.network.builder

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
import java.util.concurrent.TimeUnit

class OkHttpBuilder {

    fun build(): OkHttpClient {

        val authToken = Credentials.basic("xxxxxx", "xxxxxxx")
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY


        val headerAuthorizationInterceptor = Interceptor { chain ->
            var request = chain.request()
            val headers = request.headers().newBuilder()
                .add("Accept", "application/json")
                .add("Content-Type", "application/json")
                .add("Authorization", authToken)
                .build()
            request = request.newBuilder().headers(headers).build()
            chain.proceed(request)
        }
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(headerAuthorizationInterceptor)
            .addNetworkInterceptor(headerAuthorizationInterceptor)
            .build()
    }
}