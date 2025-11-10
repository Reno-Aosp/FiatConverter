package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;
import fiat.converter.demo.Fiat.Yen;

public class YenFactory extends CurrencyFactory {
    // Child class extending parent CurrencyFactory
    // Demonstrates inheritance: YenFactory inherits from CurrencyFactory
    // No polymorphism here - just a concrete factory implementation

    @Override
    public Currency createCurrency(double amount) {
        // Method overriding: YenFactory provides its own createCurrency implementation
        return new Yen(amount);
    }
}