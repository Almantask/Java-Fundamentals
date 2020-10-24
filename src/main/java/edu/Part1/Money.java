package edu.Part1;

import java.math.BigDecimal;

public class Money {
    public String Currency;
    public BigDecimal Value;

    public Money(String currency, BigDecimal value){
        Currency = currency;
        Value = value;
    }

    public String toString() {
        return String.format("%s %.2f", Currency, Value);
    }
}
