# PulseDesk

This is a small project for educational purposes.

A support ticket management system, where user comments are automatically analyzed by AI and converted into tickets, if appropriate.

## Tech Stack

- Java 21
- Spring Boot
- Maven
- IntelliJ
- HuggingFace account and API token
- Node.js & React

## Local Development Setup

### 1. Clone the repository

```
git clone https://github.com/JustinasBliujus/ticket_comment_ai_classifier
```

### 2. Navigate to the project

```
cd .\ticket_comment_ai_classifier\
```

### 3. Setup IDE and Maven

- On the right hand side open Maven and sync project.
- If not Maven icon is present, **right click on pom.xml** -> Add as Maven project
  
Set the environment variables in IntelliJ (or another way)
- Open **Run Configurations** -> Edit Configurations
- Find Spring Boot run config
- Choose Java 21
- Find main class path (com.pulse.desk.tickets.TicketsApplication)
- Add environment variables:
  
```
HF_ACCESS_TOKEN=your token here;
```

Run the application.
Backend will start at `http://localhost:8080`
Frontend will be served from the static folder. Frontend was built with assistance of claude.ai

## Or Run With Docker
- Run Docker Daemon
- Starting at root **ticket_comment_ai_classifier** folder:

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
            "id": "b42a3340-a16e-4a07-a312-f84d6decb5f3",
            "ticket": {
                "id": "88b4f09e-780c-4a00-99ec-5841e8349d7b",
                "title": "App Crashes on Save",
                "category": "BUG",
                "priority": "HIGH",
                "summary": "User experienced a crash when clicking the save button, indicating a potential issue with the application's stability. Further investigation is required to determine the root cause of the crash.",
                "created": "2026-04-05T11:06:02.29661",
                "updated": "2026-04-05T11:06:02.296632"
            },
            "comment": "The app crashes when clicking save!",
            "created": "2026-04-05T11:05:59.246451"
        },
        {
            "id": "0ffa85ed-2050-409a-b43d-b52a4b70f1e8",
            "ticket": null,
            "comment": "I think this app is not bad :)",
            "created": "2026-04-05T11:07:21.056337"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 5,
        "paged": true,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "unpaged": false
    },
    "size": 5,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "totalElements": 2,
    "totalPages": 1
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
"id": "b42a3340-a16e-4a07-a312-f84d6decb5f3",
    "ticket": {
        "id": "88b4f09e-780c-4a00-99ec-5841e8349d7b",
        "title": "App Crashes on Save",
        "category": "BUG",
        "priority": "HIGH",
        "summary": "User experienced a crash when clicking the save button, indicating a potential issue with the application's stability. Further investigation is required to determine the root cause of the crash.",
        "created": "2026-04-05T11:06:02.296610053",
        "updated": "2026-04-05T11:06:02.296631876"
    },
    "comment": "The app crashes when clicking save!",
    "created": "2026-04-05T11:05:59.246451445"
}
```

Response (not a ticket):
```json
{
    "id": "0ffa85ed-2050-409a-b43d-b52a4b70f1e8",
    "ticket": null,
    "comment": "I think this app is not bad :)",
    "created": "2026-04-05T11:07:21.056336588"
}
```

---

### GET /tickets?page=0

Response:
```json
{
    "content": [
        {
            "id": "88b4f09e-780c-4a00-99ec-5841e8349d7b",
            "title": "App Crashes on Save",
            "category": "BUG",
            "priority": "HIGH"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 1,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 5,
        "paged": true,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "unpaged": false
    },
    "size": 5,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "totalElements": 1,
    "totalPages": 1
}
```

---

### GET /tickets/{id}

Response:
```json
{
    "id": "88b4f09e-780c-4a00-99ec-5841e8349d7b",
    "title": "App Crashes on Save",
    "category": "BUG",
    "priority": "HIGH",
    "summary": "User experienced a crash when clicking the save button, indicating a potential issue with the application's stability. Further investigation is required to determine the root cause of the crash.",
    "created": "2026-04-05T11:06:02.29661",
    "updated": "2026-04-05T11:06:02.296632"
}
```

---
