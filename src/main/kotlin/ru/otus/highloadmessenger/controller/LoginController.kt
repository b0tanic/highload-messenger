package ru.otus.highloadmessenger.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.otus.highloadmessenger.dto.LoginPostRequest
import ru.otus.highloadmessenger.service.UserService


@RestController
@Validated
@RequestMapping("/login")
class LoginController(private val userService: UserService) {

    @PostMapping
    fun loginPost(@Valid @RequestBody(required = false) loginPostRequest: LoginPostRequest): ResponseEntity<Any> {
        val user = userService.userGetId(loginPostRequest.id) ?:
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login failed")

        return try {
            ResponseEntity(userService.loginUser(user, loginPostRequest.password), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.message)
        }
    }
}
