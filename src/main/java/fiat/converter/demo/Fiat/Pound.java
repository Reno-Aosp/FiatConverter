package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

public class Pound extends Currency {
    // Child class extending parent Currency
    // Demonstrates inheritance: Pound inherits from Currency
    // No polymorphism here - just a concrete implementation

    public Pound(double amount) {
        super("Pound", "£", 0.81); // Added parameters: name, symbol, rateToUSD
        this.amount = amount; // Set amount after super call
    }

    @Override
    public String format() {
        // Method overriding: Pound provides its own format implementation
        return "£" + String.format("%.2f", amount);
    }
}