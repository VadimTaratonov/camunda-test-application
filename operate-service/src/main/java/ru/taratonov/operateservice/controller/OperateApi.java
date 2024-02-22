package ru.taratonov.operateservice.controller;

import io.camunda.operate.exception.OperateException;
import io.camunda.operate.model.ProcessInstance;
import io.camunda.operate.model.Variable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.taratonov.operateservice.model.CreateInstanceRequest;

import java.util.List;

public interface OperateApi {
    @PostMapping("/process-instances")
    void createInstance(@RequestBody CreateInstanceRequest createInstanceRequest);

    @GetMapping("/process-instances/{id}/variables")
    List<Variable> getInstanceVariables(@PathVariable Long id) throws OperateException;

    @GetMapping("/process-instances/{id}")
    ProcessInstance getProcessInstance(@PathVariable Long id) throws OperateException;
}
