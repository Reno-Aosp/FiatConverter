package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;
import fiat.converter.demo.Fiat.Rupiah;

// CHILD CLASS - concrete factory for creating Rupiah objects
public class RupiahFactory extends CurrencyFactory { // INHERITANCE: RupiahFactory IS-A CurrencyFactory
    
    // METHOD OVERRIDING - implements abstract method from parent
    @Override
    public Currency createCurrency(double rateToUSD) {
        return new Rupiah(rateToUSD); // Creates and returns Rupiah object
    }
    // POLYMORPHISM: Returns Currency type, but actual object is Rupiah
}
