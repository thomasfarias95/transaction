package com.br.api.services;

import com.br.api.domain.dtos.TransactionDTO;
import com.br.api.domain.entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {

    Transaction save(TransactionDTO transactionDTO);
    List<Transaction> findAll();
    Transaction findById(UUID id);
    Transaction update(UUID id, TransactionDTO transactionDTO);

}
