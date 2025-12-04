# Milo as a Service (MiloAAS)

![alt text](docs/assets/image.png)

Milo as a Service (MiloAAS) is a backend web API built using **Java and Spring Boot**.  
The goal of this project is to practice building a **production-style, enterprise-inspired backend** with layered architecture, authentication, authorization, and cloud-ready infrastructure.

The business domain is intentionally simple — serving photos of my cat Milo 🐈 — so the focus stays on backend design, security, and maintainability.

## Core Features (Planned)

- Retrieve random Milo photos
- Authentication & authorization using JWT
- Role-based access control (`VIEWER`, `CONTRIBUTOR`, `ADMIN`)
- User-contributed Milo photos
- Enterprise-style layered architecture
- Structured logging & consistent error handling

A detailed breakdown of the API design lives in **docs/endpoints.md**.

## Architecture Overview

MiloAAS follows a **three-layer architecture**:

- **Controller layer** – REST APIs, DTOs, validation
- **Service layer** – business logic & authorization
- **Repository layer** – persistence using Spring Data JPA

Infrastructure:
- PostgreSQL (Docker)
- Object storage for images (planned)

## Getting Started

### TL;DR

> **The intended way to run MiloAAS is via VS Code Dev Containers.**  
> This provides a fully reproducible development environment with Java, Maven, PostgreSQL, and debugging tools preconfigured.

No local Java, Maven, or PostgreSQL installation is required.

## Prerequisites

You need:
- **Docker Desktop**
- **VS Code**
- VS Code extension: **Dev Containers**

That’s it.

---

## Running the App (Dev Containers + Docker Compose)

### 1. Clone the repository

```bash
git clone https://github.com/your-username/miloaas.git
cd miloaas
```

### 2. Open in Dev Container

In VS Code:

```
Cmd/Ctrl + Shift + P → Dev Containers: Reopen in Container
```

What happens automatically:

- The Dev Container is built (Java, Maven, CLI tools)

- PostgreSQL is started via docker compose

- Both services are attached to the same Docker network

- No manual Docker commands required.

### 3. Start the Spring Boot application

Inside the Dev Container terminal:

```bash
./mvnw spring-boot:run
```

### 4. Access the API

- API base URL: http://localhost:8080

- PostgreSQL: internal Docker network (milo-db:5432)

Example health check:

```bash
curl http://localhost:8080/actuator/health
```

## Database Config

The application connects to PostgreSQL running as a Docker service.

Spring configuration (simplified): 

```yaml
spring:
  datasource:
    url: jdbc:postgresql://milo-db:5432/milo
    username: milo
    password: secret
```

> The hostname is milo-db, not localhost.

## Dev Container Tooling 

The Dev Container includes debugging tools used during development:

- psql – connect to PostgreSQL directly
- netcat (nc) – test network connectivity
- curl – test API endpoints

These tools are intentionally kept in the container for future debugging and observability.