package br.ufpe.cin.hcs3.hrpayroll.service;

import br.ufpe.cin.hcs3.hrpayroll.batch.Context;
import br.ufpe.cin.hcs3.hrpayroll.batch.contracts.Task;
import br.ufpe.cin.hcs3.hrpayroll.batch.enums.TaskStatus;
import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Payment;
import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuildPayment implements Task {

    @Override
    public TaskStatus execute(Context context) {

        Worker worker = (Worker) context.get("Worker");
        Integer days = (Integer) context.get("Days");

        Payment payment = Payment.builder()
                .dailyIncome(worker.getDailyIncome())
                .name(worker.getName())
                .days(days)
                .build();

        context.add("Payment", payment);

        return TaskStatus.SUCCESS;
    }

}
