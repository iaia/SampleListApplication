package com.example.samplelistapplication.model.lib

import android.content.Context
import com.example.samplelistapplication.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object CsvReader {
    suspend fun readForWeather(context: Context): List<Weather> {
        return withContext(Dispatchers.IO) {
            val assetManager = context.resources.assets
            val weathers = mutableListOf<Weather>()
            try {
                val inputStream = assetManager.open("data.csv")
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferReader = BufferedReader(inputStreamReader)
                var line = bufferReader.readLine()
                line = bufferReader.readLine()
                while (line != null) {
                    val tokens = line.split(",")
                    if (tokens.isNotEmpty()) {
                        val weather = Weather(
                            0,
                            tokens[0].toInt(),
                            tokens[1].toInt(),
                            tokens[2].toInt(),
                            tokens[3].toInt(),
                            tokens[4].toFloat(),
                            tokens[5].toFloat(),
                            tokens[6],
                            tokens[7].toFloat()
                        )
                        weathers.add(weather)
                    }
                    line = bufferReader.readLine()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return@withContext weathers
        }
    }
}