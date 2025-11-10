package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

// CHILD CLASS - inherits from Currency parent class
public class Dollar extends Currency { // INHERITANCE: Dollar IS-A Currency
     public Dollar(double rateToUSD) {
         super("US Dollar", "USD", rateToUSD); // Call parent constructor
        }
     // This class inherits all methods from Currency (toUSD, fromUSD, format, etc.)

     @Override
     public String format(double amount) {
         // Format amount in USD with 2 decimal places
         return String.format("USD %.2f", amount);
     }

     @Override
     public String format() {
         // Provide a no-arg format fallback (if parent declares format() without args)
         return format(0.0);
     }
}