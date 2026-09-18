package ims;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Grocery")
public class Grocery extends Product {
    private String expiry;

    public Grocery() {}

    public Grocery(int id,String name,double price,int qty,int minQty,String expiry) {
        super(id,name,price,qty,minQty);
        this.expiry=expiry;
    }

    public String getType() {
        return "Grocery";
    }
}
