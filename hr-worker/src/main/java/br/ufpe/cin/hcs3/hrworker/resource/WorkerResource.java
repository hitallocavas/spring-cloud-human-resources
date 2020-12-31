package br.ufpe.cin.hcs3.hrworker.resource;

import br.ufpe.cin.hcs3.hrworker.domain.entity.Worker;
import br.ufpe.cin.hcs3.hrworker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "workers")
public class WorkerResource {

    private final WorkerService workerService;

    @GetMapping
    private ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok(workerService.findAll());
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Worker> findById(@PathVariable Long id){
        return ResponseEntity.ok(workerService.findById(id));
    }
    
}
