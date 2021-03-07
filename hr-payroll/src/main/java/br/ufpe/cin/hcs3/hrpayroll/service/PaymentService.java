package br.ufpe.cin.hcs3.hrpayroll.service;

import br.ufpe.cin.hcs3.hrpayroll.batch.Context;
import br.ufpe.cin.hcs3.hrpayroll.batch.Job;
import br.ufpe.cin.hcs3.hrpayroll.batch.enums.JobStatus;
import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final FindWorkerById findWorkerById;
    private final BuildPayment buildPayment;

    public Payment getPayment(Long workerId, Integer days) {
        Context context = new Context();
        Job job = new Job(context);
        context.add("WorkerID", workerId);
        context.add("Days", days);

        JobStatus jobStatus = job
                .addTask(findWorkerById)
                .addTask(buildPayment)
                .execute();

        if (jobStatus.equals(JobStatus.INTERRUPTED)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Houve um erro nos dados enviados");
        }

        return (Payment) context.get("Payment");
    }

}
