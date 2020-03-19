package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.BloodPressureInformationDto

interface BloodPressureService {

    fun addBloodPressureForUser(userId: Int, bloodPressureInformation: BloodPressureInformationDto)
    fun getBloodPressureForUser(userId: Int): List<BloodPressureInformationDto>?
    fun getBloodPressureRecommendation(): List<BloodPressureInformationDto>
    fun removeBloodPressureForUser(userId: Int, id: Int)
    fun removeAllBloodPressureForUser(userId: Int)

}