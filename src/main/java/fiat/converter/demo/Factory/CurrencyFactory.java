package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;

// PARENT CLASS (Abstract) - Factory Pattern
// This defines the interface for creating Currency objects
public abstract class CurrencyFactory {
    // Abstract method - must be implemented by child factory classes
    public abstract Currency createCurrency(double rateToUSD);
}

