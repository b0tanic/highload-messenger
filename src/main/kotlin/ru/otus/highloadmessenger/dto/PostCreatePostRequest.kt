package ru.otus.highloadmessenger.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param text Текст поста
 */
data class PostCreatePostRequest(

    @get:JsonProperty("text", required = true) val text: kotlin.String
) {

}

