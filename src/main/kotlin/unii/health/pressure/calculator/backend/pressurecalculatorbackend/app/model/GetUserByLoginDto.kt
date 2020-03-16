package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model

import javax.validation.constraints.NotBlank

data class GetUserByLoginDto constructor(
        @field:NotBlank(message = "login is mandatory") val login: String) {
}