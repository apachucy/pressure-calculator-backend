package unii.health.pressure.calculator.backend.pressurecalculatorbackend.configuration

import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.impl.DefaultMapperFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.BloodPressureToBloodPressureDtoMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserCreateMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserDtoToUserMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.UserLoginMapper

@Configuration
class MapperConfiguration {
    @Bean
    fun mapperFacade(): MapperFacade {
        val mapperFactory: DefaultMapperFactory = DefaultMapperFactory.Builder().build()
        UserLoginMapper.Configurer.configure(mapperFactory)
        UserCreateMapper.Configurer.configure(mapperFactory)
        UserDtoToUserMapper.Configurer.configure(mapperFactory)
        BloodPressureToBloodPressureDtoMapper.Configurer.configure(mapperFactory)
        return mapperFactory.mapperFacade;

    }
}