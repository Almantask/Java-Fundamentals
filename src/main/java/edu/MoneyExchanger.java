package edu;

import java.math.BigDecimal;

public class MoneyExchanger {
    public static Money exchange(Money money, String newCurrency){
        BigDecimal multiplier = getMultiplier(newCurrency);
        BigDecimal newValue = money.Value.multiply(multiplier);
        return new Money(newCurrency, newValue);
    }

    // How do we get a multiplier is a detail.
    // It could be hardcoded
    // It could be updated from online services, etc
    private static BigDecimal getMultiplier(String currency){
        switch(currency.toLowerCase()){
            case "eur" :
                return new BigDecimal("1");
            case "gbp" :
                return new BigDecimal("0.907084713");
            case "dol" :
                return new BigDecimal("1.171499");
            default:
                return new BigDecimal("-1");
        }
    }
}
