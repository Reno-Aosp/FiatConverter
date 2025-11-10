package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;
import fiat.converter.demo.Fiat.Aud;

public class AudFactory extends CurrencyFactory {
    // Child class extending parent CurrencyFactory
    // Demonstrates inheritance: AudFactory inherits from CurrencyFactory
    // No polymorphism here - just a concrete factory implementation

    @Override
    public Currency createCurrency(double amount) {
        // Method overriding: AudFactory provides its own createCurrency implementation
        return new Aud(amount);
    }
}