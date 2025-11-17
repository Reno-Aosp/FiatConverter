package fiat.converter.demo.Service;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ConverterService {
    // No inheritance or polymorphism here - this is a plain service class
    // Uses composition with ExchangeRateService for live rates
    private final ExchangeRateService exchangeRateService;

    public ConverterService(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public Map<String, Double> getRates() {
        Map<String, Double> rates = exchangeRateService.getRates();
        System.out.println("DEBUG: ConverterService returning rates: " + rates);
        return rates;
    }

    public double convert(String from, String to, double amount) {
        Map<String, Double> rates = exchangeRateService.getRates();
        
        System.out.println("DEBUG: Converting " + amount + " from " + from + " to " + to);
        System.out.println("DEBUG: Available rates: " + rates.keySet());
        
        if (rates.isEmpty()) {
            throw new IllegalStateException("Exchange rates not loaded yet. Please try again in a few seconds.");
        }
        
        if (!rates.containsKey(from)) {
            throw new IllegalArgumentException("Unknown currency code: " + from);
        }
        
        if (!rates.containsKey(to)) {
            throw new IllegalArgumentException("Unknown currency code: " + to);
        }

        double rateFrom = rates.get(from);
        double rateTo = rates.get(to);

        // Convert to USD first, then to target currency
        double usdAmount = amount / rateFrom;
        double result = usdAmount * rateTo;
        
        System.out.println("DEBUG: Result = " + result);
        return result;
    }
}
