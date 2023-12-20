package com.teamsparta.blog.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.teamsparta.blog.entity.Post
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class PostDto(
        val postId: Long?,

        @JsonProperty("title")
        val _title: String?,

        @JsonProperty("username")
        val _username: String?,

        @JsonProperty("contents")
        val _contents: String?
) {
        lateinit var createdAt: LocalDateTime
        lateinit var updatedAt: LocalDateTime

        companion object {
                fun fromEntity(post: Post): PostDto {
                        val dto = PostDto(
                                postId = post.id,
                                _title = post.title,
                                _username = post.username,
                                _contents = post.contents,
                        )
                        dto.createdAt = post.createdAt
                        dto.updatedAt = post.updatedAt
                        return dto
                }

                fun fromEntities(posts: List<Post>): List<PostDto> {
                        return posts.map {
                                val dto = PostDto(
                                        postId = it.id,
                                        _title = it.title,
                                        _username = it.username,
                                        _contents = it.contents
                                )
                                dto.createdAt = it.createdAt
                                dto.updatedAt = it.updatedAt
                                dto
                        }
                }
        }
}

data class PostResopnse(val id: Long, val title: String, val username: String, val contents: String) {}
