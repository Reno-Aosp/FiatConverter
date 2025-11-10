package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

public class Euro extends Currency {
    // Child class extending parent Currency
    // Demonstrates inheritance: Euro inherits from Currency
    // No polymorphism here - just a concrete implementation

    public Euro(double amount) {
        super("Euro", "€", 0.92); // Added parameters: name, symbol, rateToUSD
        this.amount = amount; // Set amount after super call
    }

    @Override
    public String format() {
        // Method overriding: Euro provides its own format implementation
        return "€" + String.format("%.2f", amount);
    }
}