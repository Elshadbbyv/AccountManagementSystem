package com.bbyv.AccountManagementSystem.dto.request;



import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

public class CreateAccountRequest {

    @NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "Invalid Name: Name is NULL")
    private String customerId;
    @Min(value = 0, message = "Invalid Amount: Amount cannot under 0$")
    private BigDecimal initialCredit
;

    public CreateAccountRequest(String customerId, BigDecimal initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateAccountRequest that)) return false;

        if (!Objects.equals(customerId, that.customerId)) return false;
        return Objects.equals(initialCredit, that.initialCredit);
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (initialCredit != null ? initialCredit.hashCode() : 0);
        return result;
    }
}
