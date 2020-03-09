package unii.health.pressure.calculator.backend.pressurecalculatorbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class PressureCalculatorBackendApplication

fun main(args: Array<String>) {
    runApplication<PressureCalculatorBackendApplication>(*args)
}
