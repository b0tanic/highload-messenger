package ru.otus.highloadmessenger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HighloadMessengerApplication

fun main(args: Array<String>) {
	runApplication<HighloadMessengerApplication>(*args)
}
