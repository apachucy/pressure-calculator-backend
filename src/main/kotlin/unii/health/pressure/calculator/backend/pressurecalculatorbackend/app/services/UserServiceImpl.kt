package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.UserDto


//TODO:
class UserServiceImpl @Autowired constructor(val userRepository: UserRepository) : UserService {

   override fun addUser(user: UserDto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun login(user: UserDto): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}