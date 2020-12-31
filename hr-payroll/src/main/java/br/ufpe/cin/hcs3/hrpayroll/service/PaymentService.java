package br.ufpe.cin.hcs3.hrpayroll.service;

import br.ufpe.cin.hcs3.hrpayroll.config.AppConfig;
import br.ufpe.cin.hcs3.hrpayroll.domain.constants.RestConstants;
import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Payment;
import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${hr-worker.host}")
    private String hrWorkerHost;

    private final AppConfig appConfig;

    public Payment getPayment(Long workerId, Integer days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());

        Worker worker = appConfig.restTemplate()
                .getForObject(this.hrWorkerHost + RestConstants.GET_WORKER_BY_ID_URI,
                                   Worker.class,
                                   uriVariables);

        return Payment.builder()
                .dailyIncome(worker.getDailyIncome())
                .name(worker.getName())
                .days(days)
                .build();
    }

}
