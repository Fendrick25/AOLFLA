# Warehouse Management System

A RESTful API for Warehouse Inventory System

## Technology Used

**Java:** Spring Boot: 2.7.6

**Database:** MySQL

## Getting Started

1. Configure application.yml file

```
# Configure database properties

spring:
  application:
    name: warehouse-service
  jpa:
    hibernate:
      ddl-auto: create # change to "create" to generate schema table
                       # change to "drop" to drop schema table 
                       # change to "none" to do nothing to schema table
    open-in-view: false
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/warehouse
    username: {MySQL USERNAME} -> MySQL username
    password: {MYSQL PASSWORD} -> MySQL password
    initialization-mode: always

```

2. Run InventorySystemApplication.java

```
@SpringBootApplication
public class InventorySystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventorySystemApplication.class, args);
	}
}
```

## Documentation

```
http://localhost:8180/swagger-ui.html
```
