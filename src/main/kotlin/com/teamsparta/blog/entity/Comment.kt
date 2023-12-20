package com.teamsparta.blog.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
class Comment(
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            val id: Long? = null,

            @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name="post_id")
            var post: Post,

            @Column(name = "username")
            var username: String,

            @Column(name = "contents")
            var contents: String?
): Time() {
    init {
        post.addComment(this)
    }

    fun update(username: String, contents: String?) {
        this.username = username
        this.contents = contents
    }
}