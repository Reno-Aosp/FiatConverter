package fiat.converter.demo.Factory;

import fiat.converter.demo.Currency;
import fiat.converter.demo.Fiat.Dollar;

// CHILD CLASS - concrete factory for creating Dollar objects
public class DollarFactory extends CurrencyFactory { // INHERITANCE: DollarFactory IS-A CurrencyFactory
    
    // METHOD OVERRIDING - implements abstract method from parent
    @Override
    public Currency createCurrency(double rateToUSD) {
        return new Dollar(rateToUSD); // Creates and returns Dollar object
    }
    // POLYMORPHISM: Returns Currency type, but actual object is Dollar
}
