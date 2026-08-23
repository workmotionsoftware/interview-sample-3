# Interview Problem — Money Transfer API

A Spring Boot project used to run a live coding / PR-review interview around

## How to run

Requirements: JDK 21+ and Maven.

```bash
mvn spring-boot:run
```

The app boots with an in-memory H2 database and seeds accounts `1` and `2`,
each with a balance of `100.00`.

Endpoints:

- Transfer: `POST /api/v1/transfers` — body `{ "from": 1, "to": 2, "amount": 80 }`

```bash
curl -X POST http://localhost:8080/api/v1/transfers \
  -H "Content-Type: application/json" \
  -d '{"from":1,"to":2,"amount":80}'
```