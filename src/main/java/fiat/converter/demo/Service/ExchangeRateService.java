package fiat.converter.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.scheduling.annotation.Scheduled;
import jakarta.annotation.PostConstruct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Service to fetch real-time exchange rates from external API
@Service
public class ExchangeRateService {
    private final WebClient webClient;
    private final Map<String, Double> rates = new ConcurrentHashMap<>();
    
    public ExchangeRateService() {
        // Initialize WebClient to call Frankfurter API (free, reliable, ECB data, no API key)
        this.webClient = WebClient.builder()
                .baseUrl("https://api.frankfurter.app")
                .build();
        
        // Initialize with fallback rates in case API is down
        initializeFallbackRates();
    }

    // Initialize with fallback rates to ensure service is always operational
    private void initializeFallbackRates() {
        rates.put("USD", 1.0);
        rates.put("IDR", 15500.0);
        rates.put("EUR", 0.92);
        rates.put("JPY", 156.3);
        rates.put("GBP", 0.81);
        rates.put("AUD", 1.54);
        System.out.println("✓ Initialized with fallback exchange rates: " + rates.size() + " currencies");
    }

    // Fetch rates immediately when service starts
    @PostConstruct
    public void init() {
        fetchRates();
    }

    // Scheduled task: fetch rates every 60 seconds (adjust based on API limits)
    @Scheduled(fixedDelay = 60000) // 60000 ms = 60 seconds
    public void fetchRates() {
        try {
            System.out.println("→ Fetching live rates from Frankfurter API (European Central Bank data)...");
            
            // Call Frankfurter API to get latest rates with USD as base currency
            ExchangeRateResponse response = webClient.get()
                    .uri("/latest?from=USD")
                    .retrieve()
                    .bodyToMono(ExchangeRateResponse.class)
                    .block(); // Blocking call (sync)

            if (response != null && response.rates != null && !response.rates.isEmpty()) {
                // Update rates map with fresh data from API
                rates.clear();
                rates.putAll(response.rates);
                rates.put("USD", 1.0); // Ensure USD is always present as base
                System.out.println("✓✓✓ SUCCESS! Live exchange rates updated from ECB: " + rates.size() + " currencies");
                System.out.println("    Sample: 1 USD = " + rates.get("EUR") + " EUR, " + rates.get("IDR") + " IDR");
            } else {
                System.err.println("✗ API returned empty response, keeping existing rates");
            }
        } catch (Exception e) {
            System.err.println("✗ Failed to fetch from API: " + e.getMessage());
            System.err.println("   Continuing with fallback rates");
            e.printStackTrace();
        }
    }

    // Get current exchange rates
    public Map<String, Double> getRates() {
        return new ConcurrentHashMap<>(rates); // Return copy for thread safety
    }

    // Response structure from exchangerate.host API
    record ExchangeRateResponse(String base, String date, Map<String, Double> rates) {}
}
