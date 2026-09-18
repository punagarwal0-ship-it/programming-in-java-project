# Inventory Management System

**Student Name:** Puneet Agarwal  
**Registration No.:** 25BAI11166

## Overview
A Java console application for managing products, stock, suppliers, prices, low-stock alerts, reports, and stock history.

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
**JDK 17 or newer.**
Check Java:
```powershell
java -version
javac -version
```

## Install, Compile and Run

1. Clone the repository:

```bash
git clone <your-public-repository-url>
cd programming-in-java-project/InventorySystem_Puneet_Agarwal
```

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

## Screenshots

1. Main menu
<img width="204" height="387" alt="image" src="https://github.com/user-attachments/assets/31816599-a73c-42ff-a46d-1824f60b6921" />

2. Product list
   <img width="632" height="124" alt="image" src="https://github.com/user-attachments/assets/8c3b8587-71db-47a7-bdec-1bd112668336" />

3. Inventory report
   <img width="273" height="181" alt="image" src="https://github.com/user-attachments/assets/47d03e47-3e0d-46fe-a10f-007ec4a655ed" />

4. Add product 
<img width="244" height="193" alt="image" src="https://github.com/user-attachments/assets/008d79d6-216e-4c7b-a146-ac8786203039" />

## Project Structure
```text
README.md
statement.md
InventorySystem/
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
