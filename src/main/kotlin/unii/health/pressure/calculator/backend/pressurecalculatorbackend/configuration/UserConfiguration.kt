package unii.health.pressure.calculator.backend.pressurecalculatorbackend.configuration

import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.impl.DefaultMapperFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserCreateMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserLoginMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserDtoToUserMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserRepository
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserService
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserServiceImpl

@Configuration
class UserConfiguration {

    @Bean
    fun userServiceImpl(userRepository: UserRepository,
                        loginMapper: UserLoginMapper,
                        createMapper: UserCreateMapper,
                        userMapperDTo: UserDtoToUserMapper
    ): UserService {
        return UserServiceImpl(userRepository, loginMapper, createMapper, userMapperDTo)
    }

    @Bean
    fun mapperFacade(): MapperFacade {
        val mapperFactory: DefaultMapperFactory = DefaultMapperFactory.Builder().build()
        UserLoginMapper.Configurer.configure(mapperFactory)
        UserCreateMapper.Configurer.configure(mapperFactory)
        UserDtoToUserMapper.Configurer.configure(mapperFactory)
        return mapperFactory.mapperFacade;

    }

}