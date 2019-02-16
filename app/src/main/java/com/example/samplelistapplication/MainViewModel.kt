package com.example.samplelistapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samplelistapplication.model.Comment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val test = "aiuo"
    var comments = MutableLiveData<List<Comment>>().apply {
        postValue(listOf())
    }

    fun createComments() {
        GlobalScope.launch {
            delay(3000)
            comments.postValue((1..10000).map {
                Comment(it, "", 1, "$it comment")
            })
        }
    }
}