package com.example.samplelistapplication.model

data class Weather(
    val id: Int? = null,
    val year: Int,
    val month: Int,
    val day: Int,
    val hour: Int,
    val temperature: Float, // celsius
    val windSpeed: Float, // (m/s)
    val windDirection: String,
    val precipitation: Float // (m/s)
) {
    fun time() = "$year/$month/$day $hour:00:00"
}