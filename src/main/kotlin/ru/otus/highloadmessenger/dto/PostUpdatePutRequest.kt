package ru.otus.highloadmessenger.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id Идентификатор поста
 * @param text Текст поста
 */
data class PostUpdatePutRequest(

    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:JsonProperty("text", required = true) val text: kotlin.String
) {

}

