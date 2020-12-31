package br.ufpe.cin.hcs3.hrworker.transport.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(){
        super(HttpStatus.NOT_FOUND, "Resource not found");
    }
}
