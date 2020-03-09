package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.UserDto

interface UserService {

    fun addUser(user: UserDto);
    fun login(user: UserDto): User;
}