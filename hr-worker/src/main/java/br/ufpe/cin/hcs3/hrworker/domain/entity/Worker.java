package br.ufpe.cin.hcs3.hrworker.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_worker")
@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double dailyIncome;
}
