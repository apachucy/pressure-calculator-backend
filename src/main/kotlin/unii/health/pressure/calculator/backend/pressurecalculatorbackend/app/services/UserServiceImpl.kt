package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import org.springframework.beans.factory.annotation.Autowired
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserCreateMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserLoginMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserDtoToUserMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.CreateUserDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.LoginDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.UserDto


//TODO:
class UserServiceImpl @Autowired constructor(val userRepository: UserRepository,
                                             val loginMapper: UserLoginMapper,
                                             val createMapper: UserCreateMapper,
                                             val userMapperDto: UserDtoToUserMapper) : UserService {

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

    override fun getUserByLogin(login: String): UserDto? {
        return userRepository.findUserByLogin(login)?.let { userMapperDto.map(it) }
    }

    override fun getAllUsers(): List<UserDto>? {
        var userList: List<User>? = userRepository.findAll()
        var userLists: List<UserDto> = ArrayList()

        userList?.forEach {
            userLists += userMapperDto.map(it)
        }
        return userLists
    }

    override fun getUserById(id: Int): UserDto? {
        return userMapperDto.map(userRepository.getOne(id))
    }
}