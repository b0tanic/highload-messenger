package ru.otus.highloadmessenger.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.Valid

/**
 * 
 * @param id Идентификатор пользователя
 * @param firstName Имя
 * @param secondName Фамилия
 * @param birthdate Дата рождения
 * @param biography Интересы
 * @param city Город
 */
data class User(

    @get:JsonProperty("id") val id: kotlin.String,

    @get:JsonProperty("first_name") val firstName: kotlin.String? = null,

    @get:JsonProperty("second_name") val secondName: kotlin.String? = null,

    @field:Valid
    @get:JsonProperty("birthdate") val birthdate: java.time.LocalDate? = null,

    @get:JsonProperty("biography") val biography: kotlin.String? = null,

    @get:JsonProperty("city") val city: kotlin.String? = null
) {

}

