package ru.taratonov.camundaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanRequest {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private Integer dependentAmount;
    private Integer salary;
    private Boolean result;
}
