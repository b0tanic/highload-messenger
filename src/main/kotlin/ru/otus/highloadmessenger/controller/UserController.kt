package ru.otus.highloadmessenger.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.otus.highloadmessenger.dto.User
import ru.otus.highloadmessenger.dto.UserRegisterPost200Response
import ru.otus.highloadmessenger.dto.UserRegisterPostRequest
import ru.otus.highloadmessenger.service.UserService

@RestController
@Validated
@RequestMapping("/user")
class UserController(private val userService: UserService) {


    @GetMapping(
        value = ["/get/{id}"],
        produces = ["application/json"]
    )
    fun userGetIdGet(@PathVariable("id") id: String): ResponseEntity<User> {
        return when (val user = userService.userGetId(id)) {
            null -> ResponseEntity<User>(HttpStatus.NOT_FOUND)
            else -> ResponseEntity(user, HttpStatus.OK)
        }
    }


    @PostMapping(
        value = ["/register"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun userRegisterPost(@Valid @RequestBody(required = false) userRegisterPostRequest: UserRegisterPostRequest?): ResponseEntity<UserRegisterPost200Response> {
        return ResponseEntity(userService.userRegister(userRegisterPostRequest), HttpStatus.OK)
    }


    @GetMapping(
        value = ["/search"],
        produces = ["application/json"]
    )
    fun userSearchGet(@NotNull @Valid @RequestParam(value = "first_name", required = true) firstName: String,
                      @NotNull @Valid @RequestParam(value = "last_name", required = true) lastName: String)
    : ResponseEntity<List<User>> {
        return ResponseEntity(userService.userSearchGet(firstName, lastName), HttpStatus.OK)
    }
}
