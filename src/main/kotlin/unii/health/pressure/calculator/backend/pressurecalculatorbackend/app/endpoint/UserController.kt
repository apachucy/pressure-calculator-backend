package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.endpoint

import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.CreateUserDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.UserDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserService
import javax.validation.Valid

@Slf4j
@RestController
class UserController @Autowired constructor(var userService: UserService) {


    @PostMapping(value = ["addUser"])
    fun addUser(@RequestBody @Valid user: CreateUserDto): ResponseEntity<*> {
        userService.addUser(user)
        return ResponseEntity.ok().build<Any>()
    }

    @PostMapping(value = ["userByName"])
    fun getUserByLogin(@RequestBody @Valid login: String): User? {

        return userService.getUserByLogin(login)
    }


    @PostMapping(value = ["user"])
    fun getUser(@RequestBody @Valid id: Int): UserDto? {
        return userService.getUserById(id)
    }

    @GetMapping(value = ["user"])
    fun getUser(): List<UserDto>? {
        return userService.getAllUsers()
    }
    //TODO: Login

}