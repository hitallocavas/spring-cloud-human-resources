package br.ufpe.cin.hcs3.hrpayroll.service;

import br.ufpe.cin.hcs3.hrpayroll.batch.Context;
import br.ufpe.cin.hcs3.hrpayroll.batch.contracts.Task;
import br.ufpe.cin.hcs3.hrpayroll.batch.enums.TaskStatus;
import br.ufpe.cin.hcs3.hrpayroll.client.WorkerFeignClient;
import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindWorkerById implements Task {

    private final WorkerFeignClient workerFeignClient;

    @Override
    public TaskStatus execute(Context context) {

        try {
            Long workerID = (Long) context.get("WorkerID");
            Worker worker = workerFeignClient.findById(workerID).getBody();
            context.remove("WorkerID");
            context.add("Worker", worker);
            return TaskStatus.SUCCESS;
        } catch (Exception e){
            log.error(e.getMessage());
            return TaskStatus.FAIL;
        }
    }

}
