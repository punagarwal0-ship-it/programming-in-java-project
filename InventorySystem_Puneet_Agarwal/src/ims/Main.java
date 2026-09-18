package ims;
import java.util.Scanner;
public class Main {
    static Scanner sc=new Scanner(System.in); static Inventory inv=new Inventory();
    public static void main(String[]a){System.out.println("=== INVENTORY MANAGEMENT SYSTEM ===");while(true){menu();int c=i("Choice: ");try{switch(c){
                    case 1->add();case 2->inv.showProducts();case 3->inv.search(t("Search: "));case 4->inv.updatePrice(i("ID: "),d("New price: "));
                    case 5->inv.addStock(i("ID: "),i("Quantity: "));case 6->inv.sell(i("ID: "),i("Quantity: "));case 7->supplier();case 8->inv.showSuppliers();
                    case 9->inv.lowStock();case 10->inv.report();case 11->inv.history();case 12->inv.reflection();case 13->inv.delete(i("ID: "));
                    case 0->{System.out.println("Goodbye!");return;}default->System.out.println("Invalid choice.");}}catch(Exception e){System.out.println("Error: "+e.getMessage());}}}

    static void menu(){System.out.println("\n1 Add Product\n2 View Products\n3 Search\n4 Update Price\n5 Add Stock\n6 Sell\n7 Add Supplier\n8 View Suppliers\n9 Low Stock\n10 Report\n11 Stock History\n12 Reflection Demo\n13 Delete\n0 Exit");}

    static void add(){int id=i("ID: ");String n=t("Name: ");double p=d("Price: ");int q=i("Initial quantity: "),m=i("Minimum stock: ");int type=i("1 Electronic, 2 Grocery: ");if(type==1)inv.addProduct(new Electronic(id,n,p,q,m,t("Brand: ")));else if(type==2)inv.addProduct(new Grocery(id,n,p,q,m,t("Expiry date: ")));else throw new IllegalArgumentException("Invalid type.");System.out.println("Product added.");}

    static void supplier(){inv.addSupplier(new Supplier(i("ID: "),t("Name: "),t("Phone: ")));System.out.println("Supplier added.");}

    static String t(String s){System.out.print(s);return sc.nextLine().trim();} 

    static int i(String s){while(true)try{return Integer.parseInt(t(s));}catch(Exception e){System.out.println("Enter a valid integer.");}} 

    static double d(String s){while(true)try{return Double.parseDouble(t(s));}catch(Exception e){System.out.println("Enter a valid number.");}}
}
