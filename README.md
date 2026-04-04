# PulseDesk

This is a small project for educational purposes.

A support ticket management system, where user comments are automatically analyzed by AI and converted into tickets, if appropriate.

## Prerequisites

- Java 21
- Maven
- Node.js
- HuggingFace account and API token
- IntelliJ

## Local Development Setup

### 1. Clone the repository

```
git clone https://github.com/JustinasBliujus/ticket_comment_ai_classifier
```

### 2. Navigate to the backend project

```
cd tickets
```

Set the environment variables in IntelliJ (or another way)
- Open **Run Configurations** -> Edit Configurations
- Find Spring Boot run config
- Add environment variables:
```
HF_ACCESS_TOKEN=your token here;
DB_USERNAME=this can be set to anything;
DB_PASSWORD=this aswell;
```

Run the backend:
```
./mvnw spring-boot:run
```

Backend will start at `http://localhost:8080`
Frontend will be served from the static folder. Frontend was built with assistance of claude.ai

## Or Run With Docker

Starting at .../tickets folder

```
docker build -t pulse-desk .
docker run -p 8080:8080 -e HF_ACCESS_TOKEN=your_token_here pulse-desk
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/comments?page=0` | Get paginated comments |
| POST | `/comments` | Submit a new comment |
| GET | `/tickets?page=0` | Get paginated ticket summaries |
| GET | `/tickets/{id}` | Get full ticket details |

## Endpoint examples
### GET /comments?page=0

Response:
```json
{
  "content": [
    {
      "id": "abc-123",
      "comment": "The app crashes when clicking save!",
      "ticket": {
        "id": "xyz-456",
        "title": "App Crashes During Save Process",
        "category": "BUG",
        "priority": "HIGH",
        "summary": "The app crashes while attempting to save data..."
      },
      "created": "2024-01-01T10:00:00"
    }
  ],
  "totalElements": 25,
  "totalPages": 3,
  "number": 0,
  "size": 10
}
```

---

### POST /comments

Request:
```json
{
  "comment": "The app crashes when clicking save!"
}
```

Response (ticket created):
```json
{
  "id": "abc-123",
  "comment": "The app crashes when clicking save!",
  "ticket": {
    "id": "xyz-456",
    "title": "App Crashes During Save Process",
    "category": "BUG",
    "priority": "HIGH",
    "summary": "The app crashes while attempting to save data..."
  },
  "created": "2024-01-01T10:00:00"
}
```

Response (not a ticket):
```json
{
  "id": "abc-123",
  "comment": "Great app, love it!",
  "ticket": null,
  "created": "2024-01-01T10:00:00"
}
```

---

### GET /tickets?page=0

Response:
```json
{
  "content": [
    {
      "id": "xyz-456",
      "title": "App Crashes During Save Process",
      "category": "BUG",
      "priority": "HIGH"
    }
  ],
  "totalElements": 10,
  "totalPages": 1,
  "number": 0,
  "size": 10
}
```

---

### GET /tickets/{id}

Response:
```json
{
  "id": "xyz-456",
  "title": "App Crashes During Save Process",
  "category": "BUG",
  "priority": "HIGH",
  "summary": "The app crashes while attempting to save data. This issue is causing productivity loss and potential data loss.",
  "created": "2024-01-01T10:00:00",
  "updated": "2024-01-01T10:00:00"
}
```

---
