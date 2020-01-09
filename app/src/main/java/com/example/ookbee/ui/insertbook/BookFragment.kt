package com.example.architecturecomponent.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.ookbee.R
import com.example.ookbee.ui.BookViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookFragment : Fragment() {

    private val viewModel: BookViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        callInsert()
    }

    private fun callInsert(){
        viewModel.bookResp.observe(this, Observer {
            if(it != null ){
                viewModel.bookResp.removeObservers(this)
            }
            viewModel.bookResp.postValue(null)
        })

    }

}
