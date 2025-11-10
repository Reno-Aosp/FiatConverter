package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;
import fiat.converter.demo.Fiat.Euro;

public class EuroFactory extends CurrencyFactory {
    // Child class extending parent CurrencyFactory
    // Demonstrates inheritance: EuroFactory inherits from CurrencyFactory
    // No polymorphism here - just a concrete factory implementation

    @Override
    public Currency createCurrency(double amount) {
        // Method overriding: EuroFactory provides its own createCurrency implementation
        return new Euro(amount);
    }
}