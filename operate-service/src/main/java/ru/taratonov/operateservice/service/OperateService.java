package ru.taratonov.operateservice.service;

import io.camunda.operate.exception.OperateException;
import io.camunda.operate.model.ProcessInstance;
import io.camunda.operate.model.Variable;
import ru.taratonov.operateservice.model.CreateInstanceRequest;

import java.util.List;

public interface OperateService {
    void createInstance(CreateInstanceRequest createInstanceRequest);

    List<Variable> getInstanceVariables(Long processInstanceKey) throws OperateException;

    ProcessInstance getProcessInstance(Long processInstanceKey) throws OperateException;
}
