package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;
import fiat.converter.demo.Fiat.Rupiah;

public class RupiahFactory extends CurrencyFactory {
    public Currency createCurrency(double rateToUSD) {
        return new Rupiah(rateToUSD);
    }
    
}
