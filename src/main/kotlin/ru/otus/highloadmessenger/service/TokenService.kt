package ru.otus.highloadmessenger.service

import org.springframework.security.oauth2.jwt.*
import org.springframework.stereotype.Service
import ru.otus.highloadmessenger.dto.User
import ru.otus.highloadmessenger.repository.UserRepository
import java.time.Duration
import java.time.Instant

@Service
class TokenService(
    private val jwtDecoder: JwtDecoder,
    private val jwtEncoder: JwtEncoder,
    private val userRepository: UserRepository,
) {
    private val expiration = 2*60*60*1000L

    fun createToken(user: User): String {
        val jwsHeader = JwsHeader.with { "HS256" }.build()
        val claims = JwtClaimsSet.builder()
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plus(Duration.ofMillis(expiration)))
            .subject(user.firstName)
            .claim("userId", user.id)
            .build()
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).tokenValue
    }

    fun parseToken(token: String): User? {
        return try {
            val jwt = jwtDecoder.decode(token)
            val userId = jwt.claims["userId"] as String
            userRepository.userGetId(userId)
        } catch (e: Exception) {
            null
        }
    }
}