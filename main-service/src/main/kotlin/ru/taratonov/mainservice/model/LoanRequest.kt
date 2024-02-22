package ru.taratonov.mainservice.model

data class LoanRequest(
    val id: Long? = null,
    val name: String? = null,
    val surname: String? = null,
    val age: Int? = null,
    val dependentAmount: Int? = null,
    val salary: Int? = null,
    val result: Boolean? = null
)
