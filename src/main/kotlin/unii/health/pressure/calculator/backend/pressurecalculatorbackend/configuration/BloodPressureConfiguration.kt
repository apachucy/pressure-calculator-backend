package unii.health.pressure.calculator.backend.pressurecalculatorbackend.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.BloodPressureToBloodPressureDtoMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.BloodPressureRepository
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.BloodPressureService
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.BloodPressureServiceImpl
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.UserRepository

@Configuration
class BloodPressureConfiguration {
    @Bean
    fun bloodPressureServiceImpl(bloodPressureRepository: BloodPressureRepository,
                                 userRepository: UserRepository,
                                 bloodPressureToBloodPressureDtoMapper: BloodPressureToBloodPressureDtoMapper,
                                 objectMapper: ObjectMapper): BloodPressureService {
        return BloodPressureServiceImpl(bloodPressureRepository, userRepository,
                bloodPressureToBloodPressureDtoMapper, objectMapper)
    }

}