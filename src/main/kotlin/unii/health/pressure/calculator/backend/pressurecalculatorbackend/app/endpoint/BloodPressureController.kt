package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.endpoint

import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.BloodPressureInformationDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.BloodPressureInformationWithUserIdDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.GetUserByIdDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.UserIdBloodPressureIdDto
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services.BloodPressureService
import javax.validation.Valid


@RestController
@Slf4j
public class BloodPressureController @Autowired constructor(val bloodPressureService: BloodPressureService) {

    @PostMapping(value = ["bloodPressureForUser"])
    fun getBloodPressureForUser(@RequestBody @Valid getUserByIdDto: GetUserByIdDto): List<BloodPressureInformationDto>? {
        return bloodPressureService.getBloodPressureForUser(getUserByIdDto.userId)
    }

    @PostMapping(value = ["addBloodPressureForUser"])
    fun addBloodPressureForUser(@RequestBody @Valid bloodPressureInformationWithUserIdDto: BloodPressureInformationWithUserIdDto) {
        bloodPressureService.addBloodPressureForUser(bloodPressureInformationWithUserIdDto.getUserByIdDto.userId,
                bloodPressureInformationWithUserIdDto.bloodPressureInformationDto)
    }

    @PostMapping(value = ["removeBloodPressureForUser"])
    fun removeBloodPressureForUser(@RequestBody @Valid userIdBloodPressureIdDto: UserIdBloodPressureIdDto) {
        bloodPressureService.removeBloodPressureForUser(userIdBloodPressureIdDto.userId,
                userIdBloodPressureIdDto.bloodPressureInformationId)
    }
    @GetMapping(value=["bloodPressureInformation"])
    fun retrieveBloodPressureInformation(): List<BloodPressureInformationDto>{
        return bloodPressureService.getBloodPressureRecommendation()
    }
}