package com.teamsparta.blog.repository

import com.teamsparta.blog.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post?, Long?> { }