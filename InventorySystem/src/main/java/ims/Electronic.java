package ims;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Electronic")
public class Electronic extends Product {
    private String brand;

    public Electronic() {}

    public Electronic(int id,String name,double price,int qty,int minQty,String brand) {
        super(id,name,price,qty,minQty);
        this.brand=brand;
    }

    public String getType() {
        return "Electronic";
    }
}
