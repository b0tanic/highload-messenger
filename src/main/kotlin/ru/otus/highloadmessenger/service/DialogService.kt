package ru.otus.highloadmessenger.service

import org.springframework.stereotype.Service
import ru.otus.highloadmessenger.dto.DialogMessage
import ru.otus.highloadmessenger.dto.DialogUserIdSendPostRequest
import ru.otus.highloadmessenger.repository.DialogRepository

@Service
class DialogService(private val dialogRepository: DialogRepository) {

    fun dialogUserIdListGet(userId: String): List<DialogMessage> {
        return arrayListOf();
    }

    fun dialogUserIdSendPost(userId: String, dialogUserIdSendPostRequest: DialogUserIdSendPostRequest?): Unit {

    }
}