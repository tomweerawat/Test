package com.example.ookbee.ui

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ookbee.data.model.BookRequest
import com.example.ookbee.data.model.BookResponse
import com.example.ookbee.data.repository.BookUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class BookViewModel(private val call: BookUseCase) : ViewModel() {


    var bookResp = MutableLiveData<BookResponse>()

    val errorMessage: MutableLiveData<String> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun insertBook(userId: Int,data: BookRequest) {
        call.execute(userId,data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveLoginStart() }
            .doOnTerminate { onRetrieveLoginFinish() }
            .subscribe({ resp ->
                onRetrieveLoginSuccess(resp)
            },
                {
                    onRetrieveLoginError()
                }
            )
    }
    private fun onRetrieveLoginSuccess(user: BookResponse) {
        bookResp.value = user
        Timber.e("onRetrieveLoginSuccess")
    }

    private fun onRetrieveLoginError() {
        errorMessage.value = "Failure"
        Timber.e("onRetrieveLoginError")
    }

    private fun onRetrieveLoginFinish() {
        Timber.e("onRetrieveLoginFinish")
    }

    private fun onRetrieveLoginStart() {
        Timber.e("onRetrieveLoginStart")
    }


}