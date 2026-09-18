package ims;
public class Supplier {
    private int id; private String name; private String phone;
    public Supplier(int id,String name,String phone){if(id<=0)throw new IllegalArgumentException("Supplier ID must be positive.");if(name==null||name.isBlank())throw new IllegalArgumentException("Supplier name cannot be empty.");this.id=id;this.name=name;this.phone=phone;}
    public int getId(){return id;} public String getName(){return name;} public String getPhone(){return phone;}
    public String toString(){return "ID: "+id+" | Name: "+name+" | Phone: "+phone;}
}