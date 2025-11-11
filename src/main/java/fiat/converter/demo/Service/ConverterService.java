package fiat.converter.demo.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    // No inheritance or polymorphism here - this is a plain service class
    // Uses composition with Map for currency rates storage
    private final Map<String, Double> rates = new ConcurrentHashMap<>();

    public ConverterService() {
        rates.put("USD", 1.0);
        rates.put("IDR", 16500.0);
        rates.put("EUR", 0.92);
        rates.put("JPY", 156.3);
        rates.put("GBP", 0.81);
        rates.put("AUD", 1.54);
    }

    public Map<String, Double> getRates() { return rates; }

    public double convert(String from, String to, double amount) {
        if (!rates.containsKey(from) || !rates.containsKey(to))
            throw new IllegalArgumentException("Unknown currency code");

        double rateFrom = rates.get(from);
        double rateTo = rates.get(to);

        double usdAmount = amount / rateFrom;
        return usdAmount * rateTo;
    }
}
