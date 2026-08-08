# Bergut API

**Bergut API** is the backend service for **Bergut**, a fitness analytics platform that synchronizes activities from Strava (and future providers such as Komoot), processes workout statistics, and exposes a REST API for web and mobile clients.

The project is built with **Java** and **Spring Boot** using a clean, modular architecture designed for future extensibility.

---

# Features

* 🔐 JWT authentication
* 🚴 Strava OAuth 2.0 integration
* 🔄 Automatic access token refresh
* 📥 Activity synchronization
* 📊 Fitness analytics
* 📈 Personal record detection
* 🌍 RESTful API
* 🗄 PostgreSQL persistence
* 🧩 Provider-based architecture (Strava, Komoot, Garmin...)
* 📱 Designed for Web and Android clients

---

# Technology Stack

* Java 21
* Spring Boot 3
* Spring Web
* Spring Security
* Spring Data JPA
* PostgreSQL
* Hibernate
* Flyway
* Lombok
* MapStruct
* Maven

---

# Project Structure

```text
src/main/java
└── com.bergut.api
    ├── config/
    ├── security/
    ├── common/
    │
    ├── users/
    ├── auth/
    ├── activities/
    ├── analytics/
    ├── providers/
    │   ├── common/
    │   ├── strava/
    │   └── komoot/
    │
    └── notifications/
```

The project follows a **feature-based architecture**, where each module encapsulates its own controllers, services, repositories, DTOs, and entities.

---

# Requirements

* Java 21+
* Maven 3.9+
* PostgreSQL 16+

---

# Getting Started

Clone the repository:

```bash
git clone https://github.com/yourusername/bergut-api.git
cd bergut-api
```

Configure the database and Strava credentials in `application.yml` or via environment variables.

Run the application:

```bash
./mvnw spring-boot:run
```

The API will be available at:

```text
http://localhost:8081
```

---

# Configuration

Example `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bergut
    username: postgres
    password: password

  jpa:
    hibernate:
      ddl-auto: validate

strava:
  client-id: YOUR_CLIENT_ID
  client-secret: YOUR_CLIENT_SECRET
  redirect-uri: http://localhost:8081/api/v1/providers/strava/callback

jwt:
  secret: CHANGE_ME
```

---

# API Overview

## Authentication

```text
POST /api/v1/auth/login
POST /api/v1/auth/register
POST /api/v1/auth/refresh
```

---

## Strava

```text
GET  /api/v1/providers/strava/connect
GET  /api/v1/providers/strava/callback
DELETE /api/v1/providers/strava
```

---

## Activities

```text
GET /api/v1/activities
GET /api/v1/activities/{id}
GET /api/v1/activities/recent
```

---

## Analytics

```text
GET /api/v1/analytics/dashboard
GET /api/v1/analytics/personal-records
GET /api/v1/analytics/trends
```

---

# OAuth Flow

```text
Client
    │
    ▼
GET /providers/strava/connect
    │
    ▼
Strava Authorization
    │
    ▼
User grants permission
    │
    ▼
Callback
    │
    ▼
Exchange authorization code
    │
    ▼
Store OAuth tokens
    │
    ▼
Initial activity synchronization
```

The backend manages OAuth tokens internally. Access tokens are automatically refreshed before expiration.

---

# Database

Core entities:

```text
User

OAuthAccount

Activity

Lap

Split

PersonalRecord
```

The application stores activities in a provider-independent format, making it easy to add additional fitness platforms.

---

# Architecture

```text
Angular / Android
        │
        ▼
 REST API (Spring Boot)
        │
 ├── Authentication
 ├── Activities
 ├── Analytics
 ├── Provider Integrations
 └── Synchronization
        │
        ▼
 PostgreSQL
        │
        ▼
 Strava API
```

---

# Roadmap

### Authentication

* [x] Strava OAuth
* [ ] JWT authentication
* [ ] User registration

### Activities

* [x] OAuth integration
* [ ] Initial synchronization
* [ ] Incremental synchronization
* [ ] Webhook support

### Analytics

* [ ] Personal records
* [ ] Weekly statistics
* [ ] Monthly statistics
* [ ] Training load
* [ ] Progress charts

### Integrations

* [x] Strava
* [ ] Komoot
* [ ] Garmin

### Clients

* [ ] Angular Web
* [ ] Android

---

# Development

Run tests:

```bash
./mvnw test
```

Build the project:

```bash
./mvnw clean package
```

---

# License

This project is licensed under the MIT License.
