package com.example.samplelistapplication.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.example.samplelistapplication.itemComments
import com.example.samplelistapplication.model.Comment

class CommentController : TypedEpoxyController<List<Comment>>() {
    override fun buildModels(comments: List<Comment>) {
        comments.forEach { comment ->
            itemComments {
                id(comment.id)
                avatar(comment.avatar)
                comment(comment.comment)
            }
        }
    }
}