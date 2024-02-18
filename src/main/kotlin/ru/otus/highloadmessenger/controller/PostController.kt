package ru.otus.highloadmessenger.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.otus.highloadmessenger.dto.Post
import ru.otus.highloadmessenger.dto.PostCreatePostRequest
import ru.otus.highloadmessenger.dto.PostUpdatePutRequest
import ru.otus.highloadmessenger.service.PostService

@RestController
@Validated
@RequestMapping("/post")
class PostController(private val postService: PostService) {


    @PostMapping(
        value = ["/create"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun postCreatePost(@Valid @RequestBody(required = false) postCreatePostRequest: PostCreatePostRequest?): ResponseEntity<kotlin.String> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @PutMapping(
        value = ["/delete/{id}"],
        produces = ["application/json"]
    )
    fun postDeleteIdPut(@PathVariable("id") id: kotlin.String): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @GetMapping(
        value = ["/feed"],
        produces = ["application/json"]
    )
    fun postFeedGet(@DecimalMin("0") @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") offset: java.math.BigDecimal,
                    @DecimalMin("1") @Valid @RequestParam(value = "limit", required = false, defaultValue = "10") limit: java.math.BigDecimal)
    : ResponseEntity<List<Post>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @GetMapping(
        value = ["/get/{id}"],
        produces = ["application/json"]
    )
    fun postGetIdGet(@PathVariable("id") id: kotlin.String): ResponseEntity<Post> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @PutMapping(
        value = ["/update"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun postUpdatePut( @Valid @RequestBody(required = false) postUpdatePutRequest: PostUpdatePutRequest?): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
