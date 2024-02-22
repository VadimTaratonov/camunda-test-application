package ru.taratonov.mainservice.service

import ru.taratonov.mainservice.model.LoanRequest

interface MainService {
    fun startProcess(loanRequest: LoanRequest)
}