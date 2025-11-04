package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;
import fiat.converter.demo.Fiat.Dollar;

public class DollarFactory extends CurrencyFactory {
    public Currency createCurrency(double rateToUSD) {
        return new Dollar(rateToUSD);
    }
    
}
