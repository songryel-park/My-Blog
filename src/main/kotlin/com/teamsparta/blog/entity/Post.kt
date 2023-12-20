package com.teamsparta.blog.entity

import com.teamsparta.blog.dto.PostResopnse
import jakarta.persistence.Entity
import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false, length = 30)
        var title: String,

        @Column(nullable = false, length = 10, updatable = false)
        var username: String,

        @Column(nullable = false)
        var contents: String
): Time() {
        @OneToMany(mappedBy = "board", cascade = [CascadeType.ALL])
        @OrderBy("created_at desc")
        var comments: MutableList<Comment> = mutableListOf()

        fun update(title: String, username: String, contents: String) {
                this.title = title
                this.username = username
                this.contents = contents
        }
        fun addComment(comment: Comment) {
                this.comments.add(comment)
        }
}