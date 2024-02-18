package ru.otus.highloadmessenger.service

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.highloadmessenger.dto.*
import ru.otus.highloadmessenger.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository, private val tokenService: TokenService) {

    @Transactional(readOnly = true)
    fun userGetId(id: String): User? {
        return userRepository.userGetId(id)
    }

    @Transactional
    fun userRegister(userRegisterPostRequest: UserRegisterPostRequest?): UserRegisterPost200Response {
        return userRepository.userRegister(userRegisterPostRequest)
    }

    @Transactional(readOnly = true)
    fun userSearchGet(firstName: String, lastName: String): List<User> {
        return userRepository.userSearchGet(firstName, lastName)
    }

    @Transactional(readOnly = true)
    fun loginUser(user: User, password: String): LoginPost200Response {
        if (userRepository.authenticateUser(user.id, password)) {
            return LoginPost200Response(tokenService.createToken(user))
        }
        throw BadCredentialsException("Invalid user id or password")
    }
}