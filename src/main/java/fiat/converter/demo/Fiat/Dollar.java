package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

public class Dollar extends Currency {
     public Dollar(double rateToUSD) {
         super("US Dollar", "USD", rateToUSD);
        }
}