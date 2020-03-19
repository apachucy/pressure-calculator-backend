package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.services

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.entity.BloodPressureInformation
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.mapper.BloodPressureToBloodPressureDtoMapper
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.model.BloodPressureInformationDto
import java.io.IOException
import java.nio.file.Files.readAllBytes
import java.nio.file.Paths.get
import kotlin.streams.toList

class BloodPressureServiceImpl @Autowired constructor(val bloodPressureRepository: BloodPressureRepository,
                                                      val userRepository: UserRepository,
                                                      val bloodPressureToBloodPressureDtoMapper: BloodPressureToBloodPressureDtoMapper,
                                                      val objectMapper: ObjectMapper) : BloodPressureService {
    @Value("classpath:/data/pressureInformation.json")
    private lateinit var resourceFile: Resource


    override fun addBloodPressureForUser(userId: Int, bloodPressureInformation: BloodPressureInformationDto) {
        val bloodPressureInformation: BloodPressureInformation = bloodPressureToBloodPressureDtoMapper.map(bloodPressureInformation)
        bloodPressureInformation.user = userRepository.getOne(userId)

        bloodPressureRepository.save(bloodPressureInformation)

    }

    override fun getBloodPressureForUser(userId: Int): List<BloodPressureInformationDto>? {
        var bloodPressureList: List<BloodPressureInformation>? = null
        val user = userRepository.findById(userId)
        return if (user.isEmpty) {
            null
        } else {
            bloodPressureList = ArrayList(user.get().bloodPressureInformationList)
            bloodPressureList.stream().map { bloodPressureToBloodPressureDtoMapper.map(it) }.toList()
        }
    }

    override fun getBloodPressureRecommendation(): List<BloodPressureInformationDto> {
        val json = loadResource()

        //annonymous new in java is replaced by object :
        val bloodPressureInformationDtoList: List<BloodPressureInformationDto> = ArrayList(objectMapper.readValue(json,
                object : TypeReference<List<BloodPressureInformationDto>>() {}))

        return bloodPressureInformationDtoList
    }

    override fun removeBloodPressureForUser(userId: Int, id: Int) {
        val bloodPressureInformation = bloodPressureRepository.findById(id)

        if (bloodPressureInformation.isPresent) {
            val user = userRepository.findById(userId)
            if (user.isPresent) {
                (user.get().bloodPressureInformationList as HashSet).remove(bloodPressureInformation.get())
            }
            bloodPressureRepository.delete(bloodPressureInformation.get())
        }
    }

    override fun removeAllBloodPressureForUser(userId: Int) {
        val user = userRepository.findById(userId)
        if (user.isPresent) {
            bloodPressureRepository.deleteAll(user.get().bloodPressureInformationList)
            user.get().bloodPressureInformationList = HashSet()
            userRepository.save(user.get())
        }
    }

    @Throws(IOException::class)
    private fun loadResource(): String? {
        return String(readAllBytes(get(resourceFile!!.uri)))
    }
}