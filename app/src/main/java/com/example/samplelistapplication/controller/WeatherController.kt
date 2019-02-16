package com.example.samplelistapplication.controller

import android.graphics.drawable.Drawable
import com.airbnb.epoxy.TypedEpoxyController
import com.example.samplelistapplication.itemWeather
import com.example.samplelistapplication.itemWeatherRainy
import com.example.samplelistapplication.model.Weather

class WeatherController(
    private val sunnyIcon: Drawable,
    private val rainyIcon: Drawable
) : TypedEpoxyController<List<Weather>>() {
    override fun buildModels(data: List<Weather>) {
        data.forEach { weather ->
            if (weather.precipitation <= 0) {
                itemWeather {
                    id(modelCountBuiltSoFar)
                    sunny(true)
                    icon(sunnyIcon)
                    time(weather.time())
                    temperature("${weather.temperature}℃")
                    windSpeed("${weather.windSpeed}(m/s)")
                    windDirection(weather.windDirection)
                }
            } else {
                itemWeatherRainy {
                    id(modelCountBuiltSoFar)
                    icon(rainyIcon)
                    time(weather.time())
                    temperature("${weather.temperature}℃")
                    windSpeed("${weather.windSpeed}(m/s)")
                    windDirection(weather.windDirection)
                    precipitation("${weather.precipitation}(m/s)")
                }
            }
        }
    }
}