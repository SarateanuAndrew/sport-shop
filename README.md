# sport-shop

This is an online platform that gives people the opportunity to buy or rent sports equipment.

## Why Microservice Architecture is Suitable for a Sport Equipment Rent Platform?

The Sport Equipment Rent Platform is well-suited for a microservice architecture for several reasons:

1. **Complexity Management**: The platform comprises multiple components, such as the User Service and Equipment Service, each with distinct responsibilities. This inherent complexity is ideal for a microservices approach, where each service can be developed, tested, and maintained independently, ensuring better organization and separation of concerns.

2. **Scalability**: Different components of the application may have varying scalability needs. For instance, the Equipment Service might require handling a high volume of data, while the User Service might experience a lower load. Microservices architecture allows each service to be scaled independently based on its specific requirements, optimizing resource usage.

3. **Enhanced Development Speed and Agility**: Microservices enable independent development, testing, and deployment of each service. This modularity leads to faster development cycles and greater agility in adapting to changes or new features, improving overall responsiveness.

4. **Fault Isolation**: In a microservices architecture, the failure of one service does not cause the entire application to fail. This is crucial for maintaining stability; for example, an issue in the Equipment Service will not affect the User Service, ensuring better reliability and uptime.

## Real-World Examples of Microservices Usage

1. **Amazon**:
   - Amazon's e-commerce platform allows users to buy and sell products online, much like the proposed platform for sports training materials. Amazon's platform consists of multiple services for managing inventory, processing payments, handling user authentication, processing orders, and delivering recommendations. Each service is a separate microservice that can be developed, deployed, and scaled independently. This architecture allows Amazon to efficiently handle millions of transactions daily and offer a seamless shopping experience.

2. **eBay**:
   - eBay, an online marketplace for buying and selling a wide range of products, utilizes a microservices architecture. Each function on the platform—such as search, listing products, user notifications, and bidding—is managed by separate microservices. This enables eBay to handle millions of users, maintain high availability, and quickly introduce new features. The "search" and "recommendation" services can be scaled independently from other parts, like payment processing, which is a benefit your platform can also gain.

## Service Boundaries:
![sport-shop drawio](https://github.com/user-attachments/assets/68d20ded-1a51-4a1d-bd00-6a3abbee0c62)
- User Management Microservice: 
Manages user accounts, registration, authentication, and authorization. It handles user roles and permissions. Manages user profiles, including personal information, payment details, purchase history, and reviews.

- Marketplace Microservice (Equipment): 
Manages the creation, updating, and deletion of training materials listed by sellers. It handles product descriptions, categories, prices, and availability.

## Technology Stack and Communication Patterns:
* Programing and Frameworks: Java, Kotlin, Spring Boot, Spring Cloud, Eureka 
* Database Management: Postgresql, Hibernate(ORM), Inteliji Idea
* Security: Spring Security, JWT
* Containerization: Docker
* Cache: Redis 
* Testing : JUnit
* Other: Postman, Lombok, other.
- **For Asynchronous Programming: WebSockets**
- **For Synchronous Programming: REST and gRPC**
    
## Design Data Management:
#### User Entity
```json
{
  "id": 1,
  "username": "john",
  "password": "password",
  "email": "email@isa.com",
  "roles": ["ROLE_USER"]
}
```

#### Equipment Entity
```json
{
  "id": 1,
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1,
}
```

# API Endpoints
## User Management Microservice Endpoints

- `POST /api/users/register`: Register a new user.  
Request
```json
{
  "username": "john",
  "password": "password",
  "email": "email@isa.com",
  "roles": ["ROLE_USER"]
}
```
Response
```json
{
 "token": "token",
}
```

- `POST /api/users/login`: Authenticate a user.  
Request
```json
{
  "username": "john",
  "password": "password"
}
```
Response
```json
{
 "token": "token",
}
```

## Marketplace Microservice Endpoints

- `POST /api/materials`: Create a new training equipment post.  
Request
```json
{
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1,
  "token": "token"
}
```
Response
```json
{
 "status": "ok"
}
```
- `PUT /api/materials`: Update a training equipment post.  
Request
```json
{
  "id": "1",
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1,
  "token": "token"
}
```
Response
```json
{
 "status": "ok"
}
```

- `GET /api/materials`: Get a list of all training materials.  
Request
```json
{
  "token": "token"
}
```
Response
```json
[
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
},
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
}
]
```
- `GET /api/materials/{id}`: Get details of a specific training material.  
Request
```json
{
  "token": "token"
}
```
Response
```json
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
}
```
- `DELETE /api/materials/{id}`: Delete a training material post.  
Request
```json
{
  "token": "token"
}
```
Response
```json
 {
  "status": "OK"
}
```
# Lobby Endpoints
- `GET /api/materials/user/{userId}`: Get all orders made by a specific user.
Request
```json
{
  "token": "token"
}
```
Response
```json
  [
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
},
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
}
]
```
# WebSocket 

- ```api/equipment/{cathegory}```
Response:

```json
  [
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
},
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
}
]
```

- ```api/equipment/all```
```json
  [
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
},
 {
  "title": "Title",
  "description": "Description",
  "price": 99.99,
  "category": "Metal",
  "postedByUserId": 1
}
]
```


## Deployment and Scaling:
Concerning containerization, I've chosen to use Docker. Docker allows you to package and run applications in a loosely isolated environment known as a container. Deploying and scaling are crucial for implementing microservices. For orchestration and scaling, I'll opt for Docker Compose.


# Lab 2
## How to run new app?

docker-compose -f docker-compose.yml up --build  This command run docker-compose.yml file that dockerize gateway, service-discovery and my 2 microcervices with their DB.

1. Run docker-compose -f docker-compose.yml up --build  This command run docker-compose.yml file that dockerize gateway, service-discovery and my 2 microcervices with their DB.
2. Test Endpoints with Status Endpoint Get: http://localhost:8081/actuator/health and http://localhost:8080/actuator/health.
3. First endpoint for client creation: http://localhost:8081/api/client/save (add request body).
4. Second endpoint for sport material creation: http://localhost:8080/materials/save (Add material request object to body).
5. Third endpoint for assign the material to user http://localhost:8081/api/client/1/1 (the numbers represent the ids of client and material)

## New Diagram:
![sport-shop drawio (1)](https://github.com/user-attachments/assets/580902eb-2498-4a21-98f1-8816c79f95b3)

## My new technologies

In my project, I’ll implement a robust microservices architecture that ensures high availability, reliability, and efficient data management. To maintain Service High Availability, I’ll use load balancers and failover strategies, along with a Circuit Breaker to prevent overloading and quickly detect failing services. For caching, Consistent Hashing will ensure balanced data distribution, and Cache High Availability will provide redundancy so data access remains fast and uninterrupted. To handle complex, distributed processes, I’ll rely on Two-Phase Commits for transactional consistency and Long-Running Saga Transactions for complex workflows. Database Replication with Failover will add redundancy, allowing the system to switch seamlessly to a backup in case of database issues. I’ll use the ELK Stack (Elasticsearch, Logstash, and Kibana) for centralized logging and analysis, making it easy to detect performance bottlenecks or errors. Finally, a Data Warehouse will store historical data, enabling detailed analysis for insights and decision-making. Together, these technologies create a resilient, scalable infrastructure capable of supporting high-performance applications.
