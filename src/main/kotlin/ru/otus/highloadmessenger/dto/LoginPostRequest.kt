package ru.otus.highloadmessenger.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid

/**
 * 
 * @param id Идентификатор пользователя
 * @param password 
 */
data class LoginPostRequest(

    @get:JsonProperty("id") val id: kotlin.String,

    @get:JsonProperty("password") val password: kotlin.String
) {

}

