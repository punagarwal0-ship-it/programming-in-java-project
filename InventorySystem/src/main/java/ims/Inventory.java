package ims;

import java.util.*;
import java.lang.reflect.*;

public class Inventory {
    private final TreeMap<Integer,Product> items=new TreeMap<>();
    private final ArrayList<Supplier> sups=new ArrayList<>();

    public void add(Product p) {
        if(items.containsKey(p.getId())) {
            System.out.println("Product ID already exists");
            return;
        }
        items.put(p.getId(),p);
        DB.save(p);
        System.out.println("Product added");
    }

    public void addSup(Supplier s) {
        sups.add(s);
        DB.addSup(s);
        System.out.println("Supplier added");
    }

    public void show() {
        if(items.isEmpty()) {
            System.out.println("No products found");
            return;
        }
        for(Product p:items.values())
            System.out.println(p);
    }

    public Product find(int id) {
        return items.get(id);
    }

    public void search(int id) {
        Product p=find(id);
        System.out.println(p==null ? "Product not found" : p);
    }

    public void updatePrice(int id,double price) {
        Product p=find(id);
        if(p==null) {
            System.out.println("Product not found");
            return;
        }
        p.setPrice(price);
        DB.save(p);
        System.out.println("Price updated");
    }

    public void delete(int id) {
        if(items.remove(id)!=null) {
            DB.delete(id);
            System.out.println("Product deleted");
        } else {
            System.out.println("Product not found");
        }
    }

    public void addStock(int id,int n) {
        Product p=find(id);
        if(p==null) {
            System.out.println("Product not found");
            return;
        }
        try {
            p.addStock(n);
            DB.save(p);
            DB.stockLog(id,n);
            System.out.println("Stock added");
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sell(int id,int n) {
        Product p=find(id);
        if(p==null) {
            System.out.println("Product not found");
            return;
        }
        try {
            p.sell(n);
            DB.save(p);
            DB.stockLog(id,-n);
            System.out.println("Sale recorded");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void alerts() {
        boolean found=false;
        for(Product p:items.values()) {
            if(p.lowStock()) {
                System.out.println(p.getId()+" | "+p.getName()+" needs reorder");
                found=true;
            }
        }
        if(!found)
            System.out.println("No low-stock products");
    }

    public void suppliers() {
        if(sups.isEmpty()) {
            System.out.println("No suppliers found");
            return;
        }
        for(Supplier s:sups)
            System.out.println(s);
    }

    public void reflect(int id) {
        Product p=find(id);
        if(p==null) {
            System.out.println("Product not found");
            return;
        }
        try {
            for(Field f=Product.class.getDeclaredFields()[0]; f!=null; ) {
                break;
            }
            for(Field f:Product.class.getDeclaredFields()) {
                f.setAccessible(true);
                System.out.println(f.getName()+" = "+f.get(p));
            }
        } catch(Exception e) {
            System.out.println("Reflection error: "+e.getMessage());
        }
    }

    public void report() {
        double val=0;
        for(Product p:items.values())
            val+=p.getPrice()*p.getQty();

        System.out.println("Products: "+items.size());
        System.out.println("Stock value: ₹"+val);
        System.out.println("Low-stock items:");
        alerts();
    }
}
