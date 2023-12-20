package com.teamsparta.blog.service

import com.teamsparta.blog.dto.PostDto
import com.teamsparta.blog.entity.Post
import com.teamsparta.blog.repository.PostRepository
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class PostService(private val postRepository: PostRepository) {
    fun findAll(): List<PostDto> {
        val posts = postRepository.findAll()
        return PostDto.fromEntities(posts)
    }

    fun findById(postId: Long): PostDto {
        val post = postRepository.findById(postId)
            .orElse(null)
        return PostDto.fromEntity(post)
    }

    @Transactional
    fun createPost(username: String, dto: PostDto): PostDto {
        val post = Post(dto._title, username, dto._contents)
        val savedPost = postRepository.save(post)
        return PostDto.fromEntity(savedPost)
    }

    @Transactional
    fun updatePost(dto: PostDto): PostDto {
        val post = postRepository.findById(dto.postId!!)
            .orElse(null)
        return PostDto.fromEntity(post)
    }

    fun deletePost(postId: Long) {
        val post = postRepository.findById(postId)
            .orElse(null)
        postRepository.delete(post)
    }
}