package com.teamsparta.blog.entity

import com.teamsparta.blog.dto.UserResponse
import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
@Table(
        uniqueConstraints = [UniqueConstraint(name = "uk_user_login_id", columnNames = ["loginId"])]
)
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false, length = 30, updatable = false)
        var username: String,

        @Column(nullable = false, length = 100)
        var password: String
) {
        fun toUserDto(): UserResponse = UserResponse(id!!, username)
}