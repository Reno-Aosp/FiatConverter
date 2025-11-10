package fiat.converter.demo;

public abstract class Currency {
    protected final String name;
    protected final String symbol;
    protected final double rateToUSD; // how many of this currency per 1 USD

    protected Currency(String name, String symbol, double rateToUSD) {
        this.name = name;
        this.symbol = symbol;
        this.rateToUSD = rateToUSD;
        
    }

    public double toUSD(double amount) { return amount / rateToUSD; }
    public double fromUSD(double amountUSD) { return amountUSD * rateToUSD; }

    public String getName() { return name; }
    public String getSymbol() { return symbol; }
    public String format(double amount) {
        return String.format("%s %.2f", symbol, amount);
    }
}


