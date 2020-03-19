package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.BloodPressureInformationDto

/**
 * TODO:
 * read Property from file
 * extend user by Account class,
 * extend bloodPressureInformation by date,
 * create new user that can read or write (depends on database rights)
 * add user shouldn't need a rights
 *
 */
/*@Component
@PropertySource(value = ["classpath:pressureInformation.json"])
@ConfigurationProperties(prefix = "")
public class JsonProperties {
    //cannot do as data class
    lateinit var pressureList: List<BloodPressureInformationDto>
}*/