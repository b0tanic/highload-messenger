package ru.otus.highloadmessenger.repository

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ru.otus.highloadmessenger.dto.User
import ru.otus.highloadmessenger.dto.UserRegisterPost200Response
import ru.otus.highloadmessenger.dto.UserRegisterPostRequest
import java.util.UUID


@Repository
class UserRepository(private val jdbcTemplate: JdbcTemplate) {

    companion object {
        const val INSERT_USER = "INSERT INTO users(id, first_name, second_name, birth_date, sex, biography, city) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"

        const val INSERT_PASSWORD = "INSERT INTO passwords(user_id, val) VALUES (?, crypt(?, gen_salt('bf')))"

        const val GET_USER_BY_ID = "SELECT id, first_name, second_name, birth_date, sex, biography, city FROM users " +
                "WHERE id = ?"

        const val GET_USERS_BY_NAMES = "SELECT id, first_name, second_name, birth_date, sex, biography, city FROM users " +
                "WHERE first_name like ? and second_name like ?"

        const val CHECK_PASSWORD = "SELECT EXISTS(SELECT 1 FROM passwords WHERE user_id = ? and val = crypt(?, val))"
    }

    fun userGetId(id: String): User? {
        try {
            return jdbcTemplate.queryForObject(
                GET_USER_BY_ID,
                { rs, _ -> User(
                    rs.getString("id"),
                    rs.getString("first_name"),
                    rs.getString("second_name"),
                    rs.getDate("birth_date").toLocalDate(),
                    rs.getString("biography"),
                    rs.getString("city")
                )},
                id
            )
        } catch (e: EmptyResultDataAccessException) {
            return null
        }
    }

    fun userRegister(userRegisterPostRequest: UserRegisterPostRequest?): UserRegisterPost200Response {
        val userId = UUID.randomUUID().toString()
        jdbcTemplate.update(INSERT_USER, userId, userRegisterPostRequest?.firstName,
            userRegisterPostRequest?.secondName, userRegisterPostRequest?.birthdate, generateSex(),
            userRegisterPostRequest?.biography, userRegisterPostRequest?.city
        )
        jdbcTemplate.update(INSERT_PASSWORD, userId, userRegisterPostRequest?.password)
        return UserRegisterPost200Response(userId)
    }

    fun userSearchGet(firstName: String, lastName: String): List<User> {
        return jdbcTemplate.query(
            GET_USERS_BY_NAMES,
            { rs, _ -> User(
                rs.getString("id"),
                rs.getString("first_name"),
                rs.getString("second_name"),
                rs.getDate("birth_date").toLocalDate(),
                rs.getString("biography"),
                rs.getString("city")
            )},
            "$firstName%", "$lastName%")
    }

    fun authenticateUser(id: String, password: String): Boolean {
        return jdbcTemplate.queryForObject(CHECK_PASSWORD, Boolean::class.java, id, password)
    }

    fun generateSex(): String {
        return listOf("M", "F").random()
    }
}
