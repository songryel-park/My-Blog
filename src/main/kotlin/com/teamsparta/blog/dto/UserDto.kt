package com.teamsparta.blog.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.teamsparta.blog.entity.User
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class UserRequestDto(
        var userId: Long?,

        @field:NotBlank
        @field:Pattern(
                regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{4,10}\$",
                message = "영문/숫자 포함 4~10자리로 입력해주세요"
        )
        @JsonProperty("username")
        private val _username: String?,

        @field:NotBlank
        @field:Pattern(
                regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[a-zA-Z0-9!@#\$%^&*]{4,10}\$",
                message = "영문/숫자/특수문자 포함 4~10자리로 입력해주세요"
        )
        @JsonProperty("password")
        private val _password: String?
) {
    val username: String
        get() = _username!!
    val password: String
        get() = _password!!

    fun toEntity(): User = User(userId, username, password)
}

data class LoginDto(
        @JsonProperty("username")
        private val _username: String?,

        @JsonProperty("password")
        private val _password: String?,
) {
    val username: String
        get() = _username!!
    val password: String
        get() = _password!!
}

data class UserResponse(val id: Long, val username: String) {}