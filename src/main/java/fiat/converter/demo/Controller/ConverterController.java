package fiat.converter.demo.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import fiat.converter.demo.Service.ConverterService;

@CrossOrigin(origins = "http://localhost:5173", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/api")
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
    public Map<String, Double> list() { return service.getRates(); }

    @PostMapping("/convert")
    public Map<String, Object> convert(@RequestBody ConvertRequest req) {
        double result = service.convert(req.from(), req.to(), req.amount());
        return Map.of(
            "from", req.from(),
            "to", req.to(),
            "amount", req.amount(),
            "result", result,
            "rate", service.getRates().get(req.to())
        );
    }
}

record ConvertRequest(String from, String to, double amount) {}

