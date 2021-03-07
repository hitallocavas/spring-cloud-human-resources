package br.ufpe.cin.hcs3.hrworker.service;

import br.ufpe.cin.hcs3.hrworker.domain.entity.Worker;
import br.ufpe.cin.hcs3.hrworker.domain.repository.WorkerRepository;
import br.ufpe.cin.hcs3.hrworker.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkerService {

    private final Environment environment;
    private final WorkerRepository repository;

    public List<Worker> findAll() {
        return this.repository.findAll();
    }

    public Worker findById(Long id) {
        String port = environment.getProperty("local.server.port");
        log.info("Porta atual: " + port);
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

}
