package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;

public abstract class CurrencyFactory {
    public abstract Currency createCurrency(double rateToUSD);
}

