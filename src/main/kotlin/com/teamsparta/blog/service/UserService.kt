package com.teamsparta.blog.service

import com.teamsparta.blog.dto.LoginDto
import com.teamsparta.blog.dto.UserRequestDto
import com.teamsparta.blog.entity.User
import com.teamsparta.blog.exception.InvalidInputException
import com.teamsparta.blog.repository.UserRepository
import com.teamsparta.blog.security.JwtTokenProvider
import com.teamsparta.blog.security.TokenInfo
import jakarta.transaction.Transactional
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.stereotype.Service
import java.util.*

@Transactional
@Service
class UserService(private val userRepository: UserRepository,
                  private val authenticationManagerBuilder: AuthenticationManagerBuilder,
                  private val jwtTokenProvider: JwtTokenProvider,
                  private val authentication: AuthenticationConfiguration) {
    fun signUp(userRequestDto: UserRequestDto): String {
        var user: User? = userRepository.findByUsername(userRequestDto.username)
        if (user != null) {
            throw InvalidInputException("중복된 ID입니다")
        }

        user = userRequestDto.toEntity()
        userRepository.save(user)
        return "회원가입 되었습니다"
    }

    // 로그인 - 토큰발행
    fun login(loginDto: LoginDto): TokenInfo {
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password)
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

        return jwtTokenProvider.createToken(authentication)
    }
}
