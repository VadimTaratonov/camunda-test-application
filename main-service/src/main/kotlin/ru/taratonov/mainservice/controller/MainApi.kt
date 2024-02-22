package ru.taratonov.mainservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import ru.taratonov.mainservice.model.LoanRequest

@Tag(name = "Main API Controller", description = "Managing loan requests")
interface MainApi {
    @PostMapping("/start")
    @Operation(summary = "Start service with loan request", description = "Allows to start business process")
    fun startProcess(
        @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Loan request",
            content = [Content(schema = Schema(implementation = LoanRequest::class))]
        ) loanRequest: LoanRequest
    ): ResponseEntity<HttpStatus>
}