package com.teamsparta.blog.dto

import com.teamsparta.blog.config.ResultCode

data class Response<T>(
        val resultCode: String = ResultCode.SUCCESS.name,
        val data: T? = null,
        val message: String = ResultCode.SUCCESS.msg,
)