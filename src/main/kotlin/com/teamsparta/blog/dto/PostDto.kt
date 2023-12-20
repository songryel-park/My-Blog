package com.teamsparta.blog.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.teamsparta.blog.entity.Post
import java.time.LocalDateTime

data class PostRequestDto(
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
                fun fromEntity(post: Post): PostRequestDto {
                        val dto = PostRequestDto(
                                postId = post.id,
                                _title = post.title,
                                _username = post.username,
                                _contents = post.contents,
                        )
                        dto.createdAt = post.createdAt
                        dto.updatedAt = post.updatedAt
                        return dto
                }

                fun fromEntities(posts: List<Post>): List<PostRequestDto> {
                        return posts.map {
                                val dto = PostRequestDto(
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