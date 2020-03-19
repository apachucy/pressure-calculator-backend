package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper

import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.BloodPressureInformation
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.BloodPressureInformationDto

@Service
class BloodPressureToBloodPressureDtoMapper @Autowired constructor(val mapperFacade: MapperFacade) {

    fun map(bloodPressureInformation: BloodPressureInformation): BloodPressureInformationDto {
        return mapperFacade.map(bloodPressureInformation, BloodPressureInformationDto::class.java)
    }

    fun map(bloodPressureInformation: BloodPressureInformationDto): BloodPressureInformation {
        return mapperFacade.map(bloodPressureInformation, BloodPressureInformation::class.java)
    }

    object Configurer {
        fun configure(mapperFactory: MapperFactory) {
            mapperFactory.classMap(BloodPressureInformation::class.java, BloodPressureInformationDto::class.java)
                    .byDefault()
                    .register()
        }
    }
}