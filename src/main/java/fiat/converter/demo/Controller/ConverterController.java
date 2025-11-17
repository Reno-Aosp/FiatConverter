package fiat.converter.demo.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;

import fiat.converter.demo.Service.ConverterService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow frontend to call backend from any origin
public class ConverterController {
    // No inheritance or polymorphism here - this is a plain REST controller
    // Uses dependency injection (DI) for ConverterService - composition pattern
    // Record ConvertRequest is a simple data carrier (no inheritance)
     private final ConverterService service;

    public ConverterController(ConverterService service) { this.service = service; }

    @GetMapping("/")
    public Map<String, String> welcome() {
        return Map.of(
            "message", "Currency Converter API",
            "endpoints", "GET /api/currencies, POST /api/convert"
        );
    }

    @GetMapping("/currencies")
    public ResponseEntity<?> list() {
        try {
            Map<String, Double> rates = service.getRates();
            if (rates.isEmpty()) {
                return ResponseEntity.status(503).body(Map.of(
                    "error", "Exchange rates not loaded yet",
                    "message", "Please try again in a few seconds"
                ));
            }
            return ResponseEntity.ok(rates);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                "error", "Failed to fetch currencies",
                "message", e.getMessage()
            ));
        }
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convert(@RequestBody ConvertRequest req) {
        try {
            System.out.println("DEBUG: Received convert request: " + req);
            double result = service.convert(req.from(), req.to(), req.amount());
            return ResponseEntity.ok(Map.of(
                "from", req.from(),
                "to", req.to(),
                "amount", req.amount(),
                "result", result,
                "rate", service.getRates().get(req.to())
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", "Invalid request",
                "message", e.getMessage()
            ));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(503).body(Map.of(
                "error", "Service unavailable",
                "message", e.getMessage()
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of(
                "error", "Conversion failed",
                "message", e.getMessage()
            ));
        }
    }
}

record ConvertRequest(String from, String to, double amount) {}

