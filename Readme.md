# Currency Converter Demo

A Spring Boot application for converting between multiple currencies (USD, IDR, EUR, JPY, GBP, AUD) using REST APIs and a simple frontend.

## Features
- RESTful API for currency conversion
- Support for multiple currencies with OOP design (inheritance, polymorphism)
- Simple HTML/JS frontend
- Spring Boot Actuator for monitoring

## Setup
1. Ensure Java 17+ and Maven are installed.
2. Clone the repo and navigate to the project directory.
3. Run `mvn spring-boot:run` to start the app.

## Endpoints
- GET / : Home page with app info
- GET /api/ : API welcome
- GET /api/currencies : List available currencies and rates
- POST /api/convert : Convert currency (JSON body: {from, to, amount})
- Actuator endpoints (e.g., /actuator/health) for monitoring

## Usage
- Access frontend at `http://localhost:8080/FrontEnd/simple.html`
- Test API with tools like Postman or curl.

## Technologies
- Java 17, Spring Boot 3.5.7
- Maven for build
- OOP concepts: Abstract classes, inheritance, method overriding