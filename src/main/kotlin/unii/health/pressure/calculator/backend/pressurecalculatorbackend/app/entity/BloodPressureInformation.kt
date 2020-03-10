package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity

import org.springframework.lang.NonNull
import javax.persistence.*

//TODO: https://github.com/orika-mapper/orika/issues/222
//Exclude nested issue

@Entity
@Table(name = "blood_pressure")
data class BloodPressureInformation(@NonNull
                                    @Column(nullable = false, name = "systolic_pulse")
                                    var systolicPulse: Int,
                                    @NonNull
                                    @Column(nullable = false, name = "diastolic_pulse")
                                    var diastolicPulse: Int,
                                    @NonNull
                                    @Column(nullable = false)
                                    var pulse: Int,
                                    @NonNull
                                    var description: String

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Int = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User = User()
}