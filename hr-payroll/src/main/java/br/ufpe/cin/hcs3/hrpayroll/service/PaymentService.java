package br.ufpe.cin.hcs3.hrpayroll.service;

import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return Payment.builder()
                .dailyIncome(237.0)
                .days(days)
                .name("Hellen")
                .build();
    }

}
