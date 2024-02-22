package ru.taratonov.mainservice.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.taratonov.mainservice.model.CreateInstanceRequest
import ru.taratonov.mainservice.model.LoanRequest
import ru.taratonov.mainservice.util.notNull

@Service
class MainServiceImpl(
    private val restTemplate: RestTemplate,
    @Value("\${custom.url.db.add}")
    private val DB_URL_ADD: String,
    @Value("\${custom.url.operate.create}")
    private val OPERATE_URL_CREATE: String,
    @Value("\${custom.bpmnProcessId}")
    private val BPMN_PROCESS_ID: String
) : MainService {
    override fun startProcess(loanRequest: LoanRequest) {
        val applicationId = addLoanRequest(loanRequest)
        val createInstanceRequest = CreateInstanceRequest(
            bpmnProcessId = BPMN_PROCESS_ID,
            variables = mutableMapOf("applicationId" to applicationId.toString())
        )

        restTemplate.postForEntity(OPERATE_URL_CREATE, createInstanceRequest, Unit::class.java)
    }

    private fun addLoanRequest(loanRequest: LoanRequest): Long {
        val id = restTemplate.postForEntity(DB_URL_ADD, loanRequest, Long::class.java)
        return id.body ?: notNull()
    }
}