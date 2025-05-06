package com.steve.ev.Contoller;

import com.steve.ev.Entity.Transaction;
import com.steve.ev.Repository.TransactionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepo transactionRepo;

    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }
}
