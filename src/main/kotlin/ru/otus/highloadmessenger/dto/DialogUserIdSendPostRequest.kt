package ru.otus.highloadmessenger.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param text Текст сообщения
 */
data class DialogUserIdSendPostRequest(

    @get:JsonProperty("text", required = true) val text: String
) {

}

