package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity

import org.springframework.lang.NonNull
import org.springframework.lang.Nullable
import javax.persistence.*


@Entity
@Table(name = "user")
data class User(
        @NonNull
        @Column(nullable = false)
        var login: String,
        @NonNull
        @Column(nullable = false)
        var password: String,
        @NonNull
        @Column(nullable = false)
        var email: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = 0

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    @Nullable
    var bloodPressureInformationList: Set<BloodPressureInformation> = HashSet<BloodPressureInformation>()


    constructor() : this("", "", "")
}