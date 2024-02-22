package ru.taratonov.mainservice.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.taratonov.mainservice.model.LoanRequest
import ru.taratonov.mainservice.service.MainService

@RestController
class MainController(
    private val mainService: MainService
) : MainApi {

    override fun startProcess(loanRequest: LoanRequest): ResponseEntity<HttpStatus> {
        mainService.startProcess(loanRequest)
        return ResponseEntity.ok(HttpStatus.OK)
    }

}