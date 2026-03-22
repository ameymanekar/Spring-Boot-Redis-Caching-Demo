# 🚀 Spring Boot + Redis Caching Demo

A simple **Spring Boot application** demonstrating how to integrate **Redis as a caching layer** to improve performance by reducing database calls.

---

## 📌 Project Overview

This project showcases a **cache-first architecture**:

* First request → Fetch from DB (simulated)
* Store result in Redis
* Subsequent requests → Fetch from Redis ⚡

---

## 🧰 Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Data Redis**
* **Docker (Redis)**
* **Maven**
* **Lombok**

---

## 🏗️ Project Structure

```
redis-demo/
 ├── controller/
 │    └── UserController.java
 ├── service/
 │    └── UserService.java
 ├── repository/
 │    └── UserRepository.java
 ├── model/
 │    └── User.java
 ├── config/
 │    └── RedisConfig.java
 └── application.properties
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/ameymanekar/springboot-kafka-order-system.git
cd redis-demo
```

---

### 2️⃣ Start Redis using Docker 🐳

```bash
docker run -d -p 6379:6379 redis
```

Verify:

```bash
docker ps
```

---

### 3️⃣ Configure Application

`src/main/resources/application.properties`

```properties
spring.redis.host=localhost
spring.redis.port=6379
server.port=9090
```

---

### 4️⃣ Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🌐 API Endpoints

### 🔹 Get User

```http
GET http://localhost:9090/users/{id}
```

### 📌 Example:

```http
GET http://localhost:9090/users/1
```

---

## 🧪 Expected Behavior

### 🔸 First Request

```
❌ From DB
```

### 🔸 Second Request

```
✅ From Redis Cache
```

---

## 🔍 Verify Redis Data

```bash
docker exec -it <container_id> redis-cli
```

Then:

```bash
keys *
get USER1
```

---

## 🧠 How It Works

```
Client → Controller → Service
        ↓
   Check Redis
        ↓
   If not found → Simulate DB
        ↓
   Save to Redis
        ↓
   Return Response
```

---

## ⚠️ Common Issues & Fixes

### ❌ RedisConnectionFailureException

✔ Ensure Redis is running:

```bash
docker ps
```

---

### ❌ Jackson Dependency Conflict

✔ Remove manual Jackson dependencies
✔ Let Spring Boot manage versions

---

### ❌ POST Not Supported

✔ Use GET request for `/users/{id}`

---

## 🚀 Future Enhancements

* Use `@Cacheable` for cleaner caching
* Add `@CacheEvict` for cache invalidation
* Integrate with Kafka for event-driven caching
* Add Redis TTL configuration
* Implement rate limiting using Redis

---

## 💡 Key Learnings

* Redis as in-memory cache ⚡
* Cache-first design pattern
* Spring Boot + Redis integration
* Docker-based setup
* Debugging real-world issues

---

## 👨‍💻 Author

**Amey Manekar**
Java Full Stack Developer

---

## ⭐ If you found this useful

Give it a ⭐ on GitHub!
