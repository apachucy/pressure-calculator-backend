package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import org.springframework.data.jpa.repository.JpaRepository
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.BloodPressureInformation

interface BloodPressureRepository : JpaRepository<BloodPressureInformation, Int> {
}