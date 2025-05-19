# OminiChat Backend

This is the backend for **OminiChat**, an offline AI chatbot web app powered by Spring Boot, MongoDB, and local LLMs via Ollama.

## 🚀 Tech Stack

- Spring Boot
- Spring AI
- MongoDB
- Ollama (Mistral, etc.)
- REST APIs

## ✨ Features

- User registration and login
- Session-based chat history
- Integration with local LLMs using Ollama
- Runs fully offline

## 🔧 Setup Instructions

### Prerequisites

- Java 17+
- MongoDB
- Ollama installed and running a model (e.g., `mistral`)
  ```bash
  ollama run mistral
  ```

### Run the Project

```bash
git clone https://github.com/your-username/ominichat-backend.git
cd ominichat-backend
./mvnw spring-boot:run
```

### Application Properties

Set your `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/ominichat
server.port=8080
```

## 📄 License

MIT License
