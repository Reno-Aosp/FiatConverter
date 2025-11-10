package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

// CHILD CLASS - inherits from Currency parent class
public class Rupiah extends Currency { // INHERITANCE: Rupiah IS-A Currency
    public Rupiah(double rateToUSD) {
         super("Indonesian Rupiah", "IDR", rateToUSD); // Call parent constructor
         }

    // METHOD OVERRIDING - replaces parent's format() method with custom implementation
    @Override // This annotation indicates we're overriding a parent method
    public String format() {
        return String.format("Rp %,.0f", amount).replace(",", ".");
    }
    // POLYMORPHISM: Rupiah can be treated as Currency, but uses its own format() method
}

