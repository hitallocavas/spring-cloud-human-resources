package br.ufpe.cin.hcs3.hrworker.domain.repository;

import br.ufpe.cin.hcs3.hrworker.domain.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> { }
