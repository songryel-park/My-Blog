package com.teamsparta.blog.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateRequest(
    @field:NotBlank
    private val title: String,

    @field:NotBlank
    private val contents: String
) {
    fun toDto(): PostDto{
        return PostDto(
            _title = title,
            _contents = contents
        )
    }
}

data class UpdateRequest(
    @field:NotNull
    val postId: Long?,

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val contents: String
) {
    fun toDto(): PostDto{
        return PostDto(
            postId = postId,
            _title = title,
            _contents = contents
        )
    }
}