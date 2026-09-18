package ims;

import jakarta.persistence.*;

@Entity
@Table(name="suppliers")
public class Supplier {
    @Id
    private int id;

    private String name;
    private String phone;

    public Supplier() {}

    public Supplier(int id,String name,String phone) {
        if(id<=0 || name==null || name.isBlank())
            throw new IllegalArgumentException("Invalid supplier details");
        this.id=id;
        this.name=name;
        this.phone=phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }

    public String toString() {
        return id+" | "+name+" | "+phone;
    }
}
