package fiat.converter.demo.Fiat;

import fiat.converter.demo.Currency;

public class Rupiah extends Currency {
    public Rupiah(double rateToUSD) {
         super("Indonesian Rupiah", "IDR", rateToUSD);
         }

    @Override
    public String format(double amount) {
        return String.format("Rp %, .0f", amount).replace(",", ".");
    }
}

