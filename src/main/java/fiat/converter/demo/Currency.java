package fiat.converter.demo;

// PARENT CLASS (Abstract Class) - defines common behavior for all currencies
public abstract class Currency {
    protected final String name;
    protected final String symbol;
    protected final double rateToUSD; // how many of this currency per 1 USD
    protected double amount;  // Changed to protected for subclass access

    // Constructor - called by child classes using super()
    protected Currency(String name, String symbol, double rateToUSD) {
        this.name = name;
        this.symbol = symbol;
        this.rateToUSD = rateToUSD;
        
    }

    // Common methods inherited by all child classes
    public double toUSD(double amount) { return amount / rateToUSD; }
    public double fromUSD(double amountUSD) { return amountUSD * rateToUSD; }

    public String getName() { return name; }
    public String getSymbol() { return symbol; }
    
    // METHOD OVERRIDING - this can be overridden by child classes (like Rupiah does)
    public String format(double amount) {
        return String.format("%s %.2f", symbol, amount);
    }

    // Abstract method for subclasses to implement
    public abstract String format();
}


