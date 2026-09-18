package ims;
public class Grocery extends Product {
    private String expiryDate;
    public Grocery(int id,String name,double price,int quantity,int minimumStock,String expiryDate){super(id,name,price,quantity,minimumStock);this.expiryDate=expiryDate;}
    public String getExpiryDate(){return expiryDate;} public String getType(){return "Grocery";}
}