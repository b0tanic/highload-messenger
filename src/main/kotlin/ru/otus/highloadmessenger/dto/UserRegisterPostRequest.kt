package ru.otus.highloadmessenger.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.Valid

/**
 * 
 * @param firstName 
 * @param secondName 
 * @param birthdate Дата рождения
 * @param biography 
 * @param city 
 * @param password 
 */
data class UserRegisterPostRequest(

    @get:JsonProperty("first_name") val firstName: kotlin.String? = null,

    @get:JsonProperty("second_name") val secondName: kotlin.String? = null,

    @field:Valid
    @get:JsonProperty("birthdate") val birthdate: java.time.LocalDate? = null,

    @get:JsonProperty("biography") val biography: kotlin.String? = null,

    @get:JsonProperty("city") val city: kotlin.String? = null,

    @get:JsonProperty("password") val password: kotlin.String? = null
) {

}

