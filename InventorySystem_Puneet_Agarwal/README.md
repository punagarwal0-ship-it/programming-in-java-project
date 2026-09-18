# Inventory Management System

**Student Name:** Puneet Agarwal  
**Registration No.:** 25BAI11166

## Overview
A plain Java 17 console application for managing products, stock, suppliers, prices, low-stock alerts, reports, and stock history.

## Features
- Add electronic and grocery products
- View and search products
- Update prices
- Add and sell stock
- Low-stock alerts
- Supplier management
- Inventory reports
- Stock history
- Delete products
- Local file persistence
- Reflection demonstration
- Input validation and exception handling

## Java Concepts
- **Inheritance:** Electronic and Grocery extend Product
- **Encapsulation:** private fields with validation methods
- **Collections:** TreeMap and ArrayList
- **Exception Handling:** LowStockException
- **Reflection:** runtime field inspection
- **File I/O:** local persistent data

## Requirements
**JDK 17 or newer.** No Maven, database server, or external library is required.

Check Java:
```powershell
java -version
javac -version
```

## Compile and Run — Windows PowerShell
From the project root:
```powershell
javac -d out src\ims\*.java
java -cp out ims.Main
```

## Compile and Run — Linux/macOS
```bash
javac -d out src/ims/*.java
java -cp out ims.Main
```

## Testing
Run the application and test adding products, searching, changing prices, adding/selling stock, low-stock alerts, suppliers, reports, deletion, invalid inputs, and restarting the program to verify saved data.

## Project Structure
```text
InventorySystem/
├── README.md
├── statement.md
├── src/
│   └── ims/
│       ├── Main.java
│       ├── Product.java
│       ├── Electronic.java
│       ├── Grocery.java
│       ├── Supplier.java
│       ├── Inventory.java
│       └── LowStockException.java
└── data/
    └── (created automatically)
```

## No Maven Required
This project intentionally uses standard Java compilation with `javac` and `java`. There is no pom.xml and no Maven setup.
