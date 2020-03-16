package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserDtoToUserMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.CreateUserDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.LoginDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.UserDto

interface UserService {

    fun addUser(login: CreateUserDto)
    fun login(login: LoginDto): User?

    fun isUserExist(userName: String): Boolean

    fun getUserByLogin(login: String): UserDto?

    fun getAllUsers(): List<UserDto>?

    fun getUserById(id: Int): UserDto?
}