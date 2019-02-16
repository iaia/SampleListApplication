package com.example.samplelistapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.samplelistapplication.model.Comment
import com.example.samplelistapplication.model.Weather
import com.example.samplelistapplication.model.lib.CsvReader
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(application: Application) :
    AndroidViewModel(application) {

    val test = "aiuo"
    val comments = MutableLiveData<List<Comment>>().apply {
        postValue(listOf())
    }
    val weathers = MutableLiveData<List<Weather>>().apply {
        postValue(listOf())
    }

    fun init() {
        GlobalScope.launch {
            comments.postValue((1..10000).map {
                Comment(it, "", 1, "$it comment")
            })
            val weathers = CsvReader.readForWeather(getApplication())
            this@MainViewModel.weathers.postValue(weathers)
        }
    }
}