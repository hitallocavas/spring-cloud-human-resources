package br.ufpe.cin.hcs3.hrpayroll.resource;

import br.ufpe.cin.hcs3.hrpayroll.domain.pojo.Payment;
import br.ufpe.cin.hcs3.hrpayroll.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "payments")
public class PaymentResource {

    private final PaymentService paymentService;

    @GetMapping(value = "{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }
}
