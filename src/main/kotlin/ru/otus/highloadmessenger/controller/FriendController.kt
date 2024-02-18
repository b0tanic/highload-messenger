package ru.otus.highloadmessenger.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import ru.otus.highloadmessenger.service.FriendService

@RestController
@Validated
@RequestMapping("/friend")
class FriendController(private val friendService: FriendService) {


    @PutMapping(
        value = ["/delete/{user_id}"],
        produces = ["application/json"]
    )
    fun friendDeleteUserIdPut(@PathVariable("user_id") userId: kotlin.String): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @PutMapping(
        value = ["/set/{user_id}"],
        produces = ["application/json"]
    )
    fun friendSetUserIdPut(@PathVariable("user_id") userId: kotlin.String): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
