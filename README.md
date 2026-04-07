📌 🔹 Repository Description

Insurance Policy Management System – A secure backend application that allows users to register, explore insurance policies, purchase plans, and track their policies with JWT-based authentication and role-based access control.

📘 🔹 README.md 
🚀 Insurance Policy Management System
A backend application built to manage insurance policies where users can securely register, browse available policies, purchase plans, and track their insurance history. The system implements authentication, authorization, and proper error handling following a clean layered architecture.

🧠 Project Overview
This project simulates a real-world insurance platform (similar to systems used by companies like HDFC Life), focusing on backend development using modern practices.

It ensures:
Secure user authentication
Structured data handling
Scalable backend architecture

🎯 Features
👤 User Features
User Registration & Login
JWT-based Authentication
Browse available insurance policies
Purchase insurance policies
View purchased policies

🔐 Admin Features
Add / Update / Delete policies
Manage users and policies

🧩 Key Concepts Used
✔ Authentication & Security
JWT (JSON Web Token) based login system
Role-Based Access Control (Admin/User)

✔ Validation
Email format validation
Password strength rules

✔ Error Handling
Custom exceptions (User not found, Invalid credentials, etc.)

✔ Database Design
Users Table
Policies Table
Purchases Table

✔ Architecture
Clean layered architecture:
Controller Layer
Service Layer
Repository Layer

🛠️ Tech Stack
Java (Spring Boot)
Spring Security (JWT)
MySQL / PostgreSQL
Maven
REST APIs

📂 Project Structure
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 ├── security/
 └── exception/
 
🔥 API Endpoints (Sample)
Method	Endpoint	Description
POST	/auth/register	Register user
POST	/auth/login	Login user
GET	/policies	Get all policies
POST	/purchase	Buy policy
GET	/my-policies	View purchased policies

⚡ How to Run
Clone the repository
Configure database in application.properties
Run the application
Test APIs using Postman

💡 Why This Project?
This project demonstrates:
Real-world backend problem solving
Secure API development
Industry-level practices used in insurance systems

📌 Future Improvements
Payment integration 💳
Policy claim system
Email notifications
Frontend integration

👨‍💻 Author
Boney Babu Mechery
