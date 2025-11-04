package fiat.converter.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {
    
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
