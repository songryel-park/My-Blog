package com.teamsparta.blog.entity

import com.teamsparta.blog.dto.PostResponse
import jakarta.persistence.Entity
import jakarta.persistence.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Entity
class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,

        @Column(nullable = false)
        val title: String,

        @Column(nullable = false)
        val username: String,

        @Column(nullable = false)
        val contents: String,

        @Column(nullable = false)
        @Temporal(TemporalType.DATE)
        val date: LocalDate,
) {
        private fun LocalDate.formatDate(): String =
                this.format(DateTimeFormatter.ofPattern("yyyyMMdd"))

        fun toPostDto(): PostResponse =
                PostResponse(id!!, title, username, contents, date)
}