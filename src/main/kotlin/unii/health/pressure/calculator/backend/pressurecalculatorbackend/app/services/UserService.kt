package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.CreateUserDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.LoginDto

interface UserService {

    fun addUser(login: CreateUserDto)
    fun login(login: LoginDto): User

    fun isUserExist(userName: String): Boolean

    fun getUserByLogin(login: String): User?

    fun getAllUsers(): List<User>?

    fun getUserById(id: Int): User?
}