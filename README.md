# ExpenseMonitor

A full-stack expense sharing and tracking application built with **Spring Boot**, **PostgreSQL**, and planned integration with **React**, **Kafka**, and **AWS**.

The backend supports user management, group creation, expense tracking, and smart sharing of expenses among group members — similar to apps like Splitwise.

## ✅ Key Features

- Create users and groups
- Add shared expenses to a group
- Split expenses among selected users
- Track who paid and who owes
- Group-wise expense summaries and balances

## 🛠 Built With

- Java 17, Spring Boot 3
- Spring Data JPA + Hibernate
- PostgreSQL
- REST API tested via Postman
- Upcoming: JWT Authentication, React Frontend, Kafka and AWS S3/SES integration

## 📬 API Usage (Postman Friendly)

You can test the following endpoints using Postman or curl.  
All requests and responses are in `application/json`.

---

### 👤 Create a User

**POST** `/api/users`

**Request Body:**
```json
{
  "name": "Yokesh",
  "username": "yokesh123",
  "password": "123"
}
```
**Response**:
```json
{
  "id": 1,
  "name": "Yokesh",
  "username": "yokesh123"
}
```

