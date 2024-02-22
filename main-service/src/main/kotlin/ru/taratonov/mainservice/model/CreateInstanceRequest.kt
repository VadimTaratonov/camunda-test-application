package ru.taratonov.mainservice.model

data class CreateInstanceRequest(
    val bpmnProcessId: String? = null,
    val variables: MutableMap<String, String>? = null
)
