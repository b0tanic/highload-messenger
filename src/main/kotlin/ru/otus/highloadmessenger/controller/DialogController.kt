package ru.otus.highloadmessenger.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.otus.highloadmessenger.dto.*
import ru.otus.highloadmessenger.service.DialogService

@RestController
@Validated
@RequestMapping("/dialog")
class DialogController(private val dialogService: DialogService) {

    @GetMapping(
        value = ["/{user_id}/list"],
        produces = ["application/json"]
    )
    fun dialogUserIdListGet(@PathVariable("user_id") userId: String): ResponseEntity<List<DialogMessage>> {
        return ResponseEntity(dialogService.dialogUserIdListGet(userId), HttpStatus.OK)
    }


    @PostMapping(
        value = ["/{user_id}/send"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun dialogUserIdSendPost(@PathVariable("user_id") userId: String,
                             @Valid @RequestBody(required = false) dialogUserIdSendPostRequest: DialogUserIdSendPostRequest?)
    : ResponseEntity<Unit> {
        return ResponseEntity(dialogService.dialogUserIdSendPost(userId, dialogUserIdSendPostRequest), HttpStatus.OK)
    }
}