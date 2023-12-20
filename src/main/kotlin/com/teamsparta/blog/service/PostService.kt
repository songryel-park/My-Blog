package com.teamsparta.blog.service

import com.teamsparta.blog.dto.PostRequestDto
import com.teamsparta.blog.repository.PostRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class PostService(private val postRepository: PostRepository) {
    fun findAll(): List<PostRequestDto> {
        val posts = postRepository.findAll()
        return PostRequestDto.fromEntities(posts)
    }

    fun findById(postId: Long): PostRequestDto {
        val post = postRepository.findById(postId)
        return PostRequestDto.fromEntity(post)
    }
}