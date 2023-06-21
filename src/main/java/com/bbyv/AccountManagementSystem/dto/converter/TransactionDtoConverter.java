package com.bbyv.AccountManagementSystem.dto.converter;

import com.bbyv.AccountManagementSystem.dto.TransactionDto;
import com.bbyv.AccountManagementSystem.model.Account;
import com.bbyv.AccountManagementSystem.model.Transaction;
import com.bbyv.AccountManagementSystem.model.TransactionType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from){
        return  new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }



}
