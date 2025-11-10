package fiat.converter.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {
    // No inheritance or polymorphism here - this is a plain REST controller
    // Uses Spring's @RestController annotation for web endpoints
    
    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
            "application", "Currency Converter API",
            "status", "running",
            "endpoints", Map.of(
                "currencies", "GET /api/currencies",
                "convert", "POST /api/convert",
                "info", "GET /api/"
            )
        );
    }
}
