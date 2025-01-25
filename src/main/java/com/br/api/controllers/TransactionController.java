package com.br.api.controllers;


import com.br.api.domain.dtos.TransactionDTO;
import com.br.api.domain.entities.Transaction;
import com.br.api.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> save (@RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.save(transactionDTO));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>>findAll (){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction>findById (@PathVariable("id")UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.findById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Transaction>findById (@PathVariable("id")UUID id, @RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.update(id, transactionDTO));
    }

}
