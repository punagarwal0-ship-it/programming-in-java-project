package ims;

import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static Inventory inv=new Inventory();

    public static void main(String[] args) {
        DB.init();

        while(true) {
            menu();
            int ch=num("Choice: ");

            try {
                switch(ch) {
                    case 1 -> addProduct();
                    case 2 -> inv.show();
                    case 3 -> inv.search(num("Product ID: "));
                    case 4 -> inv.updatePrice(num("Product ID: "),dec("New price: "));
                    case 5 -> inv.addStock(num("Product ID: "),num("Quantity: "));
                    case 6 -> inv.sell(num("Product ID: "),num("Quantity: "));
                    case 7 -> addSupplier();
                    case 8 -> inv.suppliers();
                    case 9 -> inv.alerts();
                    case 10 -> inv.report();
                    case 11 -> DB.showStockLog();
                    case 12 -> inv.reflect(num("Product ID: "));
                    case 13 -> inv.delete(num("Product ID: "));
                    case 0 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch(Exception e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    static void menu() {
        System.out.println("""

            ===== INVENTORY MANAGEMENT SYSTEM =====
            1. Add product
            2. View products
            3. Search product
            4. Update price
            5. Add stock
            6. Sell product
            7. Add supplier
            8. View suppliers
            9. Low-stock alerts
            10. Inventory report
            11. Stock movement history
            12. Reflection view
            13. Delete product
            0. Exit
            """);
    }

    static void addProduct() {
        int id=num("ID: ");
        String name=text("Name: ");
        double price=dec("Price: ");
        int qty=num("Quantity: ");
        int min=num("Minimum stock: ");
        int type=num("1. Electronic  2. Grocery: ");

        if(type==1)
            inv.add(new Electronic(id,name,price,qty,min,text("Brand: ")));
        else if(type==2)
            inv.add(new Grocery(id,name,price,qty,min,text("Expiry: ")));
        else
            System.out.println("Invalid type");
    }

    static void addSupplier() {
        inv.addSup(new Supplier(num("ID: "),text("Name: "),text("Phone: ")));
    }

    static int num(String s) {
        System.out.print(s);
        return Integer.parseInt(sc.nextLine());
    }

    static double dec(String s) {
        System.out.print(s);
        return Double.parseDouble(sc.nextLine());
    }

    static String text(String s) {
        System.out.print(s);
        return sc.nextLine();
    }
}
