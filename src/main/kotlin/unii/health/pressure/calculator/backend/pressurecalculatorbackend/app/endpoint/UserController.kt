package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.endpoint

import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.UserDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserService
import javax.validation.Valid

@Slf4j
@RestController
class UserController @Autowired constructor(var userService: UserService) {


    @PostMapping(value = ["user"])
    fun addUser(@RequestBody @Valid user: UserDto): ResponseEntity<*> {
        userService.addUser(user)
        return ResponseEntity.ok().build<Any>()

    }

}