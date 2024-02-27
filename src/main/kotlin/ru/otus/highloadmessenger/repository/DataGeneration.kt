package ru.otus.highloadmessenger.repository

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DataGeneration {

    companion object {
        fun generate(userRepository: UserRepository) {
            object {}.javaClass.getResourceAsStream("db/people.v2.csv")?.bufferedReader()?.forEachLine {
                if (it.isNotBlank()) {
                    val (fullName, birthDate, city) = it.split(',', limit = 3)
                    val (firstName, lastName) = fullName.split(" ")
                    userRepository.userRegister(
                        firstName,
                        lastName,
                        LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE),
                        null,
                        city,
                        "hackme"
                    )
                }
            }
        }
    }
}
