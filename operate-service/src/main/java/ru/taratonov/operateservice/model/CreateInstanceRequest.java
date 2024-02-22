package ru.taratonov.operateservice.model;

import lombok.Data;

import java.util.Map;

@Data
public class CreateInstanceRequest {
    private String bpmnProcessId;
    private Map<String, String> variables;
}
