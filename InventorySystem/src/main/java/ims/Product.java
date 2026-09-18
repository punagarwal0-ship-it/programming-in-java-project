package ims;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="products")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ptype")
public abstract class Product {
    @Id
    private int id;

    @NotBlank
    private String name;

    @Positive
    private double price;

    @Min(0)
    private int qty;

    @Min(0)
    private int minQty;

    public Product() {}

    public Product(int id,String name,double price,int qty,int minQty) {
        if(id<=0 || name==null || name.isBlank() || price<=0 || qty<0 || minQty<0)
            throw new IllegalArgumentException("Invalid product details");
        this.id=id;
        this.name=name;
        this.price=price;
        this.qty=qty;
        this.minQty=minQty;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQty() { return qty; }
    public int getMinQty() { return minQty; }

    public void setPrice(double price) {
        if(price<=0)
            throw new IllegalArgumentException("Price must be positive");
        this.price=price;
    }

    public void addStock(int n) {
        if(n<=0)
            throw new IllegalArgumentException("Quantity must be positive");
        qty+=n;
    }

    public void sell(int n) throws LowStockException {
        if(n<=0)
            throw new IllegalArgumentException("Quantity must be positive");
        if(n>qty)
            throw new LowStockException("Not enough stock");
        qty-=n;
    }

    public boolean lowStock() {
        return qty<=minQty;
    }

    public abstract String getType();

    public String toString() {
        return id+" | "+name+" | "+getType()+" | Price: ₹"+price+" | Stock: "+qty;
    }
}
