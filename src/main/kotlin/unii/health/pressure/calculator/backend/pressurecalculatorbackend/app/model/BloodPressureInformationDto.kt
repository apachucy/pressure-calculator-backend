package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model

data class BloodPressureInformationDto(
        var systolicPulse: Int,
        var diastolicPulse: Int,
        var pulse: Int,
        var description: String
) {}