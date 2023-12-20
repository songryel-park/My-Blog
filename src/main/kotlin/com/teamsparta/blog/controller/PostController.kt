package com.teamsparta.blog.controller

import com.teamsparta.blog.dto.CreateRequest
import com.teamsparta.blog.dto.PostDto
import com.teamsparta.blog.dto.UpdateRequest
import com.teamsparta.blog.service.PostService
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
class PostController(private val postService: PostService) {
    @PostMapping("/posts")
    fun findAll(): List<PostDto> {
        val posts = postService.findAll()
        return posts
    }

    @PostMapping("/posts/{postId}")
    fun find(@PathVariable postId: Long): PostDto {
        val post = postService.findById(postId)
        return post
    }

    @PostMapping("/post")
    fun create(@Valid @RequestBody request: CreateRequest) {
        val post = postService.createPost(request.toDto())
        return
    }

    @PostMapping("/post/{postId}")
    fun update(@PathVariable postId: Long, @Valid @RequestBody request: UpdateRequest) {
        val post = postService.updatePost(request.toDto())
        return
    }

    @PostMapping("/post/{posrId}")
    fun delete(@PathVariable postId: Long) {
        postService.deletePost(postId)
        return
    }
}