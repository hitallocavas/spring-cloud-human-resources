package br.ufpe.cin.hcs3.hrpayroll.domain.pojo;

import br.ufpe.cin.hcs3.hrpayroll.domain.contract.IPayment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Payment implements IPayment {

    private String name;
    private Double dailyIncome;
    private Integer days;

    @Override
    public Double getTotalPayment() {
        return dailyIncome*days;
    }

}
