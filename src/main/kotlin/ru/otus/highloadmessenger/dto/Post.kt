package ru.otus.highloadmessenger.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Пост пользователя
 * @param id Идентификатор поста
 * @param text Текст поста
 * @param authorUserId Идентификатор пользователя
 */
data class Post(

    @get:JsonProperty("id") val id: kotlin.String? = null,

    @get:JsonProperty("text") val text: kotlin.String? = null,

    @get:JsonProperty("author_user_id") val authorUserId: kotlin.String? = null
) {

}

