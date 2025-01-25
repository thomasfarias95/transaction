package com.br.api.services;

import com.br.api.domain.dtos.TransactionDTO;
import com.br.api.domain.entities.Transaction;
import com.br.api.repositories.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{

    private  final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
       TransactionDTO dto =  new TransactionDTO.Builder().
                total(new BigDecimal(100))
                .createdAt(LocalDateTime.now())
                        .cardNumber("12345678910111213")
                                .ccv("123")
                                        .owner("Thomas Farias")
                                                .ein("123456789")
                                                        .build();
        BeanUtils.copyProperties(transactionDTO, transaction);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(UUID id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public Transaction update(UUID id, TransactionDTO transactionDTO) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()){
            throw  new RuntimeException("Transaction not found");
        }
        BeanUtils.copyProperties(transactionDTO, transaction.get());
        return transactionRepository.save(transaction.get());
    }
}
