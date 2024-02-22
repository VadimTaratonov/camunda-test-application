package ru.taratonov.operateservice.controller;

import io.camunda.operate.exception.OperateException;
import io.camunda.operate.model.ProcessInstance;
import io.camunda.operate.model.Variable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.taratonov.operateservice.model.CreateInstanceRequest;
import ru.taratonov.operateservice.service.OperateService;
import ru.taratonov.operateservice.service.OperateServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OperateController implements OperateApi {
    private final OperateService operateService;

    @Override
    // Запуск инстанса БП с заданными параметрами
    public void createInstance(CreateInstanceRequest createInstanceRequest) {
        operateService.createInstance(createInstanceRequest);
    }

    @Override
    // Получить переменные инстанса процесса
    public List<Variable> getInstanceVariables(Long id) throws OperateException {
        return operateService.getInstanceVariables(id);
    }

    @Override
    // Получить описание инстанса процесса по идентификатору
    public ProcessInstance getProcessInstance(Long id) throws OperateException {
        return operateService.getProcessInstance(id);
    }


}
