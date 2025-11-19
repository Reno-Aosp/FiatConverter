# Currency Converter Demo

A full-stack application for converting between multiple currencies with real-time exchange rates, featuring a React frontend and Spring Boot backend.

## Features
- **Real-time Exchange Rates**: Fetches live rates from European Central Bank (ECB) via Frankfurter API, updating every 60 seconds
- **Multiple Currencies**: Support for USD, IDR, EUR, JPY, GBP, AUD
- **RESTful API**: Backend provides currency conversion endpoints
- **Modern Frontend**: React-based UI with Vite for fast development
- **OOP Design**: Backend uses abstract classes, inheritance, polymorphism for currency handling
- **Monitoring**: Spring Boot Actuator for health checks and metrics

## Technologies
- **Backend**: Java 17, Spring Boot 3.5.7, Maven
- **Frontend**: React, Vite, Tailwind CSS
- **OOP Concepts**: Abstract classes, inheritance, method overriding, polymorphism
- **Real-time Data**: Frankfurter API (ECB-backed)

## Setup & Run

### Prerequisites
- Java 17+
- Node.js 16+
- Maven 3.6+

### Backend (Spring Boot)
1. Navigate to project root: `cd "d:\Colleges Files\demo-Fiat-Converter"`
2. Run: `mvn spring-boot:run`
3. Backend starts on `http://localhost:8080`

### Frontend (React/Vite)
1. Navigate to frontend: `cd "d:\Colleges Files\demo-Fiat-Converter\frontend"`
2. Install dependencies: `npm install`
3. Start dev server: `npm run dev`
4. Frontend starts on `http://localhost:5173`

## Endpoints (Backend API)
- `GET /` : Home page with app info
- `GET /api/` : API welcome
- `GET /api/currencies` : List available currencies and live rates
- `POST /api/convert` : Convert currency (JSON body: `{from, to, amount}`)
- Actuator endpoints (e.g., `/actuator/health`) for monitoring

## Usage
- Open frontend at `http://localhost:5173` for the currency converter UI
- Backend API available at `http://localhost:8080/api/*`
- Test API with Postman or curl

## Architecture
- **Backend**: Spring Boot with OOP currency classes (abstract `Currency`, concrete subclasses like `Dollar`, `Euro`)
- **Frontend**: React components with hooks for state management
- **Real-time Rates**: Scheduled service fetches ECB data every 60 seconds
- **Error Handling**: Graceful fallbacks and user-friendly messages

## Contributing
1. Backend changes: Modify Java classes, run `mvn test`
2. Frontend changes: Modify React components, run `npm run build`
3. Ensure both services are running for full functionality