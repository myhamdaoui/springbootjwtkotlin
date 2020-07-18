package com.mhamdaoui.kotlin1.springwithkotlin.exception

import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import kotlin.RuntimeException


@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(value = [RuntimeException::class])
    fun handleAuthException(e: RuntimeException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}