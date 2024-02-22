package ru.taratonov.camundaservice.workers;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.taratonov.camundaservice.service.WorkerHelper;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class Worker {
    private final WorkerHelper workerHelper;

    @JobWorker(type = "worker",
            autoComplete = false, // сами отвечаем
            pollInterval = 500, // миллисекунд между запросами новых задач
            maxJobsActive = 5, // количество одновременно выполняемых задач данным обработчиком
            timeout = 1000, // миллисекунд на выполнение задачи. Если не уложимся, то задачу передадут другому обработчику
            requestTimeout = 100000 // время ожидания новой задачи (Long Polling)
    )
    public void handleWork(JobClient jobClient, ActivatedJob job) {
        Map<String, Object> variables = job.getVariablesAsMap();
        String operationCode = (String) variables.getOrDefault("operationCode", "UNKNOWN");
        log.info("Entered worker with operation: " + operationCode);

        Object result = workerHelper.syncExecuteTask(operationCode, variables);
        jobClient.newCompleteCommand(job)
                .variables(Map.of("result", result.toString()))
                .requestTimeout(Duration.of(3, ChronoUnit.MINUTES)) // Время на отправку gRPC команды
                .send().join();

    }
}
