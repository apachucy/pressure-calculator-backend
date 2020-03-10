package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import org.springframework.beans.factory.annotation.Autowired
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserCreateMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserLoginMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.CreateUserDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.LoginDto


//TODO:
class UserServiceImpl @Autowired constructor(val userRepository: UserRepository,
                                             val loginMapper: UserLoginMapper,
                                             val createMapper: UserCreateMapper) : UserService {

    override fun addUser(user: CreateUserDto) {
        if (!isUserExist(user.login)) {
            userRepository.save(createMapper.map(user))
        }
    }

    override fun login(login: LoginDto): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isUserExist(userName: String): Boolean {
        val user: User? = userRepository.findUserByLogin(userName)
        return user != null
    }

    override fun getUserByLogin(login: String): User? {
        return userRepository.findUserByLogin(login)
    }

    override fun getAllUsers(): List<User>? {
        return userRepository.findAll()
    }

    override fun getUserById(id: Int): User? {
        return userRepository.getOne(id)
    }
}