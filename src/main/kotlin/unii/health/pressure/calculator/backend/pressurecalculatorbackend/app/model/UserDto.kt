package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model

class UserDto(var login: String,
              var password: String,
              var email: String,
            //  var id: Int?,
              var bloodPressureInformationDtoList: HashSet<BloodPressureInformationDto>) {
}