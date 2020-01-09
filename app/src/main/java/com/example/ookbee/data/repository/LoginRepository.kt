package com.example.ookbee.data.repository

import com.example.ookbee.data.model.BookRequest
import com.example.ookbee.data.model.BookResponse
import com.example.ookbee.data.network.IBookApi
import io.reactivex.Observable

interface BookRepository {
    fun insertBook(userId: Int,operation: BookRequest): Observable<BookResponse>
}

class BookRepositoryImpl(private val api: IBookApi) : BookRepository {
    override fun insertBook(userId: Int, body: BookRequest): Observable<BookResponse> {
        return api.insertBook(userId,body)
    }

}