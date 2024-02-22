package ru.taratonov.operateservice.service;

import io.camunda.operate.CamundaOperateClient;
import io.camunda.operate.exception.OperateException;
import io.camunda.operate.model.ProcessInstance;
import io.camunda.operate.model.Variable;
import io.camunda.operate.search.SearchQuery;
import io.camunda.operate.search.VariableFilter;
import io.camunda.zeebe.client.ZeebeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.taratonov.operateservice.model.CreateInstanceRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperateServiceImpl implements OperateService {
    private final ZeebeClient zeebeClient;
    private final CamundaOperateClient operateClient;

    @Override
    public void createInstance(CreateInstanceRequest createInstanceRequest) {
        zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(createInstanceRequest.getBpmnProcessId())
                .latestVersion()
                .variables(createInstanceRequest.getVariables())
                .send()
                .join();

    }

    @Override
    public List<Variable> getInstanceVariables(Long processInstanceKey) throws OperateException {
        VariableFilter variableFilter = VariableFilter.builder().processInstanceKey(processInstanceKey).build();
        return operateClient.searchVariables(new SearchQuery.Builder().filter(variableFilter).build());

    }

    @Override
    public ProcessInstance getProcessInstance(Long processInstanceKey) throws OperateException {
        return operateClient.getProcessInstance(processInstanceKey);
    }
}
