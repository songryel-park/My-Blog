package com.teamsparta.blog.exception

class InvalidInputException(
        val fieldName: String = "",
        message: String = "Invalid Input"
) : RuntimeException(message)