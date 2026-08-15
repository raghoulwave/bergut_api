# Bergut API

**Bergut API** is the backend service for **Bergut**, a fitness analytics platform that synchronizes activities from Strava (and future providers such as Komoot), processes workout statistics, and exposes a REST API for web and mobile clients.

The project is built with **Java** and **Spring Boot** using a clean, modular architecture designed for future extensibility.

---

# Features

* 🚴 Strava integration
* 📊 Fitness analytics
* 📈 Personal record detection
* 🌍 RESTful API
* 🗄 PostgreSQL persistence
* 🧩 Provider-based architecture (Strava, Komoot...)

---

# Technology Stack

* Java 21
* Spring Boot 3
* Spring Web
* Spring Security
* Spring Data JPA
* PostgreSQL

---

# API Overview

---

## Strava

```text
GET  /api/v1/providers/strava/connect

---

# Database

Core entities:

```text
User

OAuthAccount

Activity
```

The application stores activities in a provider-independent format, making it easy to add additional fitness platforms.

---

# Roadmap

### Authentication

* [x] Strava OAuth
* [ ] JWT authentication
* [ ] User registration

### Activities

* [x] OAuth integration
* [ ] Synchronization
* [ ] Webhook support

### Analytics

* [ ] Personal records
* [ ] Weekly statistics
* [ ] Monthly statistics
* [ ] Progress charts

### Integrations

* [x] Strava
* [ ] Komoot

### Clients

* [ ] Angular Web

---

# License

This project is licensed under the MIT License.
