package br.ufpe.cin.hcs3.hrworker.service;

import br.ufpe.cin.hcs3.hrworker.domain.entity.Worker;
import br.ufpe.cin.hcs3.hrworker.domain.repository.WorkerRepository;
import br.ufpe.cin.hcs3.hrworker.transport.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;

    public List<Worker> findAll(){
        return this.repository.findAll();
    }

    public Worker findById(Long id){
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

}
