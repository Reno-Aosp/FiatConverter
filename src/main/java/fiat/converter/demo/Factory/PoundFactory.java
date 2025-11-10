package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;
import fiat.converter.demo.Fiat.Pound;

public class PoundFactory extends CurrencyFactory {
    // Child class extending parent CurrencyFactory
    // Demonstrates inheritance: PoundFactory inherits from CurrencyFactory
    // No polymorphism here - just a concrete factory implementation

    @Override
    public Currency createCurrency(double amount) {
        // Method overriding: PoundFactory provides its own createCurrency implementation
        return new Pound(amount);
    }
}