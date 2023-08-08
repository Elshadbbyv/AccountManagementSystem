package com.bbyv.AccountManagementSystem.dto;

import com.bbyv.AccountManagementSystem.model.AvgPrice;

import java.math.BigDecimal;
import java.util.Objects;

public class AvgPriceDto {
    private Integer mins;
    private BigDecimal price;
    private String symbol;

    public AvgPriceDto() {
    }

    public AvgPriceDto(Integer mins, BigDecimal price, String symbol) {
        this.mins = mins;
        this.price = price;
        this.symbol = symbol;
    }

    public Integer getMins() {
        return mins;
    }

    public void setMins(Integer mins) {
        this.mins = mins;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvgPriceDto avgPriceDto)) return false;

        if (!Objects.equals(mins, avgPriceDto.mins)) return false;
        if (!Objects.equals(price, avgPriceDto.price)) return false;
        return Objects.equals(symbol, avgPriceDto.symbol);
    }

    @Override
    public int hashCode() {
        int result = mins != null ? mins.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AvgPrice{" +
                "mins=" + mins +
                ", price=" + price +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
