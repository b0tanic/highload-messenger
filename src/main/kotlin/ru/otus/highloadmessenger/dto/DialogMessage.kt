package ru.otus.highloadmessenger.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param from Идентификатор пользователя
 * @param to Идентификатор пользователя
 * @param text Текст сообщения
 */
data class DialogMessage(

    @get:JsonProperty("from", required = true) val from: kotlin.String,

    @get:JsonProperty("to", required = true) val to: kotlin.String,

    @get:JsonProperty("text", required = true) val text: kotlin.String
) {

}

