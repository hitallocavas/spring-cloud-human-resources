package br.ufpe.cin.hcs3.hrpayroll.service;

import br.ufpe.cin.hcs3.hrpayroll.client.WorkerFeignClient;
import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Payment;
import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return Payment.builder()
                .dailyIncome(worker.getDailyIncome())
                .name(worker.getName())
                .days(days)
                .build();
    }

}
