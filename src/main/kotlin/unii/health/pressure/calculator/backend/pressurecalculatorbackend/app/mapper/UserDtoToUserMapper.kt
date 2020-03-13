package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper

import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.BloodPressureInformation
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.BloodPressureInformationDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.UserDto


@Service
class UserDtoToUserMapper @Autowired constructor(val mapperFacade: MapperFacade) {
    fun map(user: User): UserDto {
        return mapperFacade.map(user, UserDto::class.java)
    }

    fun map(user: UserDto): User {
        return mapperFacade.map(user, User::class.java)
    }


    object Configurer {
        fun configure(mapperFactory: MapperFactory) {
            mapperFactory.classMap(User::class.java, UserDto::class.java)
                    .byDefault()
                    .fieldMap("bloodPressureInformationList", "bloodPressureInformationDtoList")
                    .aElementType(BloodPressureInformation::class.java)
                    .bElementType(BloodPressureInformationDto::class.java)
                    .add()
                    .register()


        }
    }
}