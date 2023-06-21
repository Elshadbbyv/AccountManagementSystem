package com.bbyv.AccountManagementSystem.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id = "";
    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    public Transaction() {
    }
    public Transaction(BigDecimal amount, Account account){

        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.transactionType = TransactionType.INITIAL;
        this.account = account;
    }

    public Transaction( BigDecimal amount, LocalDateTime transactionDate, Account account) {
        this.id = null;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = TransactionType.INITIAL;
        this.account = account;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;

        if (!Objects.equals(id, that.id)) return false;
        if (transactionType != that.transactionType) return false;
        if (!Objects.equals(amount, that.amount)) return false;
        if (!Objects.equals(transactionDate, that.transactionDate))
            return false;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        //result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }
}
