# Inventory Management System

## Overview

Inventory Management System is a command-line Java application for managing products, stock, suppliers, prices, and inventory reports. It stores data in an H2 database and demonstrates object-oriented programming, collections, exception handling, JDBC, JPA annotations, and reflection.

## Features

- Add, view, search, update, and delete products
- Support for Electronic and Grocery product types
- Add stock and sell products
- Prevent invalid stock operations
- Automatic low-stock reorder alerts
- Add and view suppliers
- Track stock movements
- Update and display product prices
- Calculate total inventory value
- Generate inventory reports
- Store product, supplier, and stock data in H2
- Use TreeMap for sorted product storage
- Use JPA annotations on persistent classes
- Use reflection for dynamic field display

## Technologies Used

- Java 17
- Maven
- JDBC
- H2 Database
- JPA annotations
- Hibernate ORM
- JUnit 5
- Git and GitHub

## Project Structure

```text
InventorySystem/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ims/
│   │           ├── Main.java
│   │           ├── Product.java
│   │           ├── Electronic.java
│   │           ├── Grocery.java
│   │           ├── Supplier.java
│   │           ├── Inventory.java
│   │           ├── DB.java
│   │           └── LowStockException.java
│   └── test/
│       └── java/
│           └── ims/
│               └── InventoryTest.java
└── data/
README.md
statement.md
```

## Requirements

- JDK 17 or later
- Maven 3.8 or later
- Internet connection for the first Maven build

## Install and Run

1. Clone the repository:

```bash
git clone https://github.com/punagarwal0-ship-it/programming-in-java-project
cd InventorySystem
```

2. Compile the project:

```bash
mvn clean compile
```

3. Run the application:

```bash
mvn exec:java -Dexec.mainClass=ims.Main
```

If the Maven exec command is unavailable, run the compiled class from your IDE or add the Maven exec plugin to `pom.xml`.

## Testing

Run the automated tests with:

```bash
mvn test
```

The tests check product creation, price validation, stock changes, low-stock detection, and invalid sales.

## Database

The application uses an H2 file database. The database files are created automatically in the `data` folder after the first run.

## Screenshots

Add terminal screenshots here after running the project. Recommended screenshots:

1. Main menu
2. Product list
3. Low-stock alert
4. Inventory report
5. Supplier list

## Author

Name: Puneet Agarwal

Reg no.: 25BAI11166
