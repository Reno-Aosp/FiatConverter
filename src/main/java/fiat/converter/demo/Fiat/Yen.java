package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

public class Yen extends Currency {
    // Child class extending parent Currency
    // Demonstrates inheritance: Yen inherits from Currency
    // No polymorphism here - just a concrete implementation

    public Yen(double amount) {
        super("Yen", "¥", 156.3); // Added parameters: name, symbol, rateToUSD
        this.amount = amount; // Set amount after super call
    }

    @Override
    public String format() {
        // Method overriding: Yen provides its own format implementation
        return "¥" + String.format("%.0f", amount); // Yen typically no decimals
    }
}