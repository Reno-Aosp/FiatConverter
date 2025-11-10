package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

// CHILD CLASS - inherits from Currency parent class
public class Dollar extends Currency { // INHERITANCE: Dollar IS-A Currency
     public Dollar(double rateToUSD) {
         super("US Dollar", "USD", rateToUSD); // Call parent constructor
        }
     // This class inherits all methods from Currency (toUSD, fromUSD, format, etc.)
}