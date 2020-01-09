package com.example.ookbee.di


import com.example.ookbee.data.repository.BookRepository
import com.example.ookbee.data.repository.BookRepositoryImpl
import com.example.ookbee.data.repository.BookUseCase
import com.example.ookbee.data.repository.BookUseCaseCaseImpl
import com.example.ookbee.ui.BookViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val feedModule = module {

    //Login Inject
    factory<BookRepository> { BookRepositoryImpl(get()) }
    factory<BookUseCase> { BookUseCaseCaseImpl(get()) }
    //End

    viewModel { BookViewModel(get()) }
}