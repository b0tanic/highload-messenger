package ru.otus.highloadmessenger.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param userId 
 */
data class UserRegisterPost200Response(

    @get:JsonProperty("user_id") val userId: kotlin.String? = null
)

