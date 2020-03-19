package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model

data class BloodPressureInformationWithUserIdDto(val getUserByIdDto: GetUserByIdDto,
                                                 val bloodPressureInformationDto: BloodPressureInformationDto)