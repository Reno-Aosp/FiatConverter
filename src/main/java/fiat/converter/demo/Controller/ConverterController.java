package fiat.converter.demo.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiat.converter.demo.Service.ConverterService;

@RestController
@RequestMapping("/api")
public class ConverterController {
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

