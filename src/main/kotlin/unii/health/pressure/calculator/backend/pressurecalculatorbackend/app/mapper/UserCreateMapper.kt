package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper

import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.User
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.CreateUserDto

@Service
class UserCreateMapper @Autowired constructor(val mapperFacade: MapperFacade) {
    fun map(user: User): CreateUserDto {
        return mapperFacade.map(user, CreateUserDto::class.java)
    }

    fun map(login: CreateUserDto): User {
        return mapperFacade.map(login, User::class.java)
    }

    object Configurer {
        fun configure(mapperFactory: MapperFactory) {
            mapperFactory.classMap(User::class.java, CreateUserDto::class.java)
                    .byDefault()
                    /* .customize(object : CustomMapper<EmployeeEntity, EmployeeDto>() {
                         override fun mapAtoB(employeeEntity: EmployeeEntity, employeeDto: EmployeeDto, context: MappingContext) {
                             super.mapAtoB(employeeEntity, employeeDto, context)
                             val currentYear = Instant.now().atZone(com.miciu.spring.app.mapper.EmployeeMapper.ZONE)[ChronoField.YEAR]
                             val age: Int = currentYear - employeeEntity.getBirthYear()
                             employeeDto.setAge(age)
                         }

                         override fun mapBtoA(employeeDto: EmployeeDto, employeeEntity: EmployeeEntity, context: MappingContext) {
                             super.mapBtoA(employeeDto, employeeEntity, context)
                             val currentYear = Instant.now().atZone(com.miciu.spring.app.mapper.EmployeeMapper.ZONE)[ChronoField.YEAR]
                             val birthYear: Int = currentYear - employeeDto.getAge()
                             employeeEntity.setBirthYear(birthYear)
                         }
                     })*/
                    .register()
        }
    }
}