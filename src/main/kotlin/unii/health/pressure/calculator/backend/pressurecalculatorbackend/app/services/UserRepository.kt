package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import org.springframework.data.jpa.repository.JpaRepository
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User

interface UserRepository : JpaRepository<User, Int> {
    fun findUserByLogin(login: String): User?

    //fun findUserByName(name: String): User?
}