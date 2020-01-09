package com.example.ookbee.data.repository

import com.example.ookbee.data.model.BookRequest
import com.example.ookbee.data.model.BookResponse
import io.reactivex.Observable

interface BookUseCase {
    fun execute(userId: Int,body: BookRequest): Observable<BookResponse>
}

class BookUseCaseCaseImpl(private val repository: BookRepository) : BookUseCase {
    override fun execute(userId: Int, body: BookRequest): Observable<BookResponse> {
        return repository.insertBook(userId,body)
    }

}