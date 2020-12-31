package br.ufpe.cin.hcs3.hrpayroll.domain.pojo;

import lombok.Data;

@Data
public class Worker {
    private Long id;
    private String name;
    private Double dailyIncome;
}
