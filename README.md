# Merchant Product Management System

## Project Overview

Merchant Product Management System is a Java-based console application developed using Hibernate ORM and JPA. The application enables merchants to manage their profile information and products, while maintaining a relationship between merchants and products using Hibernate mappings.

This project demonstrates CRUD operations, entity relationships, JPQL queries, and database integration using MySQL.

## Technologies Used

- Java
- Hibernate ORM
- JPA (Java Persistence API)
- MySQL
- Eclipse IDE
- Maven

## Features

### Merchant Operations

- Save Merchant
- Update Merchant
- Find Merchant by ID
- Find Merchant by Name and Password
- Find Merchant by Product ID

### Product Operations

- Add Product
- Update Product
- Find Product by ID
- Find Products by Merchant Name
- Find Products by Merchant GST Number and Password

## Entity Relationship

### Merchant

A merchant can have multiple products.

### Product

Each product belongs to one merchant.

Relationship Mapping:

```java
@OneToMany(mappedBy = "m")
private List<Product> products;

@ManyToOne
@JoinColumn(name = "merchant_id")
private Merchant m;
```

## Project Structure

```
src/main/java
│
├── controller
│   └── MerchantProductController.java
│
├── dao
│   ├── MerchantDao.java
│   └── ProductDao.java
│
├── dto
│   ├── Merchant.java
│   └── Product.java
│
└── resources
    └── persistence.xml
```

## Database Tables

### Merchant

- id
- name
- gst_num
- email
- phone
- password

### Product

- id
- name
- brand
- category
- price
- merchant_id

## JPQL Queries Implemented

### Find Merchant by Name and Password

```java
select m from Merchant m
where m.name=?1 and m.password=?2
```

### Find Product by Merchant Name

```java
from Product p
where p.m.name=:name
```

### Find Product by GST Number and Password

```java
from Product p
where p.m.gst_num=:gst_num
and p.m.password=:password
```

## Learning Outcomes

Through this project, I gained hands-on experience in:

- Hibernate ORM
- JPA Entity Management
- CRUD Operations
- JPQL Queries
- One-to-Many Mapping
- Many-to-One Mapping
- MySQL Integration
- DAO Design Pattern

## Author

Durkesh

Java | Hibernate | JPA | MySQL Developer
