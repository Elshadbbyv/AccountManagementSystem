package com.bbyv.AccountManagementSystem.dto;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;


public class CustomerAccountDto {
    private String id;
    private BigDecimal balance = BigDecimal.ZERO;
    private Set<TransactionDto> transactions;
    private LocalDateTime creationDate;




    public CustomerAccountDto(String id, BigDecimal balance,  Set<TransactionDto> transactions) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
        this.creationDate = LocalDateTime.now();

    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerAccountDto that)) return false;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(balance, that.balance)) return false;
        if (!Objects.equals(creationDate, that.creationDate)) return false;
        return Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
        return result;
    }
}
