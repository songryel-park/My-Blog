package com.teamsparta.blog.security

data class TokenInfo(
        val grantType: String,
        val accessToken: String,
)