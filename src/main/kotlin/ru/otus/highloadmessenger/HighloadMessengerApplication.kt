package ru.otus.highloadmessenger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.otus.highloadmessenger.repository.DataGeneration
import ru.otus.highloadmessenger.repository.UserRepository

@SpringBootApplication
class HighloadMessengerApplication

fun main(args: Array<String>) {
	val context = runApplication<HighloadMessengerApplication>(*args)
	val userRepo = context.getBean(UserRepository::class.java)
	if (userRepo.count() < 100_000) {
		DataGeneration.generate(userRepo)
	}
}

