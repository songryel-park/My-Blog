package com.teamsparta.blog.controller

import com.teamsparta.blog.dto.PostRequestDto
import com.teamsparta.blog.service.PostService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
class PostController(private val postService: PostService) {
    @PostMapping("/posts")
    fun findAll(): List<PostRequestDto> {
        val posts = postService.findAll()
        return posts
    }

    @PostMapping("/posts/{postId}")
    fun find(@PathVariable postId: Long): PostRequestDto {
        val post = postService.findById(postId)
        return post
    }
}