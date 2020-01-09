package com.example.ookbee.data.network

import com.example.ookbee.data.model.BookRequest
import com.example.ookbee.data.model.BookResponse
import io.reactivex.Observable
import retrofit2.http.*

interface IBookApi {

    @Headers("user-key: 7cd5f10c66378443bb51b7346136680c")
    @POST("/user/{userId}/books")
    fun insertBook(@Path("userId")userId: Int,@Body body: BookRequest): Observable<BookResponse>

}