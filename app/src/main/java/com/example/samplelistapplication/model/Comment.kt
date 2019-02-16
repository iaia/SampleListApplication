package com.example.samplelistapplication.model

data class Comment(
    val id: Int,
    val avatar: String,
    val userId: Int,
    val comment: String
) {
}