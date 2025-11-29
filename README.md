# Milo as a Service (MiloAAS)

Milo as a Service (MiloAAS) is a proposed backend web API built using **Java and Spring Boot**.  
The goal of this project is to practice building a **production-style, enterprise-inspired backend** with layered architecture, authentication, authorization, file uploads, and cloud-ready infrastructure.

The core business domain is intentionally simple: serving photos of my cat Milo 🐈 — allowing the focus to remain on backend design, security, and maintainability.

---

## Core Features (Planned)

- Retrieve random Milo photos
- Authentication and authorization using JWT
- Role-based access control (VIEWER, CONTRIBUTOR, ADMIN)
- User-contributed Milo photos
- Enterprise-style layered architecture
- Structured logging and consistent error handling

A full breakdown of the API design can be found under **Proposed API Endpoints**.

---

## Architecture Overview

MiloAAS follows a classic **three-layer architecture**:

- **Controller layer** – REST endpoints, request/response DTOs, validation
- **Service layer** – business logic, authorization checks, workflows
- **Repository layer** – data access via Spring Data JPA

Infrastructure dependencies include:
- PostgreSQL for persistence
- Object storage (e.g. S3) for image files (planned)

---

## Getting Started (Local Development)

### Prerequisites

You will need the following installed:

- Java 17+
- Maven or Gradle
- Docker (for PostgreSQL)

---

### Option 1: Start PostgreSQL with Docker (Recommended)

Run the following command once to create and start a PostgreSQL container:

```bash
docker run --name milo-db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=secret \
  -e POSTGRES_DB=milo \
  -p 5432:5432 \
  -d postgres:16
```

What this does:
- Creates a PostgreSQL database named milo
- Exposes it on localhost:5432
- Persists data inside the container

To manage the database later:

```bash
docker start milo-db
docker stop milo-db
docker logs milo-db
```

### Option 2: Start PostgreSQL with Docker Compose

Alternatively, you can start PostgreSQL using Docker Compose:

```bash
docker compose up -d
```

This will start PostgreSQL on localhost:5432 using the configuration defined in docker-compose.yml.

### Application Configuration

The application is configured by default to connect to the local PostgreSQL instance.

`src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/milo
    username: postgres
    password: secret

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

If you change database credentials, be sure to update both Docker and this configuration.

### Run the Application 

From the project root:

```bash
./mvnw spring-boot:run
```

Once started, the API will be available at:

```
http://localhost:8080
```

### Development Status

This project is under active development. At the moment:

- ✅ Core domain and read-only endpoints are being built

- ⏳ Authentication and authorization are planned next

- ⏳ File uploads and object storage integration are planned

- ⏳ Metrics, monitoring, and red teaming are planned future work

Detailed design decisions and architecture rationale can be found in the project documentation.