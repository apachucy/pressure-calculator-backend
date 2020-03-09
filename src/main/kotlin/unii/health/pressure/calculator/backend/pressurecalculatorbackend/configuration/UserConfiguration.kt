package unii.health.pressure.calculator.backend.pressurecalculatorbackend.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserRepository
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserService
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserServiceImpl

@Configuration
class UserConfiguration {

    @Bean
    fun userServiceImpl(userRepository: UserRepository): UserService {
        return UserServiceImpl(userRepository)
    }

}