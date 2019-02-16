package com.example.samplelistapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.samplelistapplication.controller.WeatherController
import com.example.samplelistapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: WeatherController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.weathers.observe(this, Observer {
            controller.setData(it)
        })

        setController()
        viewModel.init()
    }

    private fun setController() {
        controller = WeatherController(
            ResourcesCompat.getDrawable(
                resources, R.drawable.ic_baseline_wb_sunny_24px, null
            )!!,
            ResourcesCompat.getDrawable(
                resources, R.drawable.ic_baseline_beach_access_24px, null
            )!!
        )
        binding.recyclerView.adapter = controller.adapter
        controller.setData(listOf())
    }
}
