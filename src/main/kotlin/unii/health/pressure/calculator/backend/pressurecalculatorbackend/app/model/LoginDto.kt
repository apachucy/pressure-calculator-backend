package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model

import javax.validation.constraints.NotBlank


data class LoginDto(
        @field:NotBlank(message = "login is mandatory")
        var login: String,

        @field:NotBlank(message = "password is mandatory")
        var password: String) {
}
