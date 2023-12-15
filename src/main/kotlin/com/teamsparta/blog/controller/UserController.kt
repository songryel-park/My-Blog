package com.teamsparta.blog.controller

import com.teamsparta.blog.dto.LoginDto
import com.teamsparta.blog.dto.Response
import com.teamsparta.blog.dto.UserRequestDto
import com.teamsparta.blog.security.TokenInfo
import com.teamsparta.blog.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {
    @PostMapping("/signup")
    fun signUp(@RequestBody userRequestDto: UserRequestDto): Response<Unit> {
        val resultMsg: String = userService.signUp(userRequestDto)
        return Response(message = resultMsg)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): Response<TokenInfo> {
        val tokenInfo = userService.login(loginDto)
        return Response(data = tokenInfo)
    }
}