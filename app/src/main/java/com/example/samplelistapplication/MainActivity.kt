package com.example.samplelistapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.samplelistapplication.controller.CommentController
import com.example.samplelistapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: CommentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.comments.observe(this, Observer {
            controller.setData(it)
        })


        setController()
        viewModel.createComments()
    }

    private fun setController() {
        controller = CommentController()
        binding.recyclerView.adapter = controller.adapter
        controller.setData(viewModel.comments.value ?: listOf())
    }
}
