package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

public class Aud extends Currency {
    // Child class extending parent Currency
    // Demonstrates inheritance: Aud inherits from Currency
    // No polymorphism here - just a concrete implementation

    public Aud(double amount) {
        super("Australian Dollar", "A$", 1.54); // Added parameters: name, symbol, rateToUSD
        this.amount = amount; // Set amount after super call
    }

    @Override
    public String format() {
        // Method overriding: Aud provides its own format implementation
        return "A$" + String.format("%.2f", amount);
    }
}