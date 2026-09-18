package ims;
public class Electronic extends Product {
    private String brand;
    public Electronic(int id,String name,double price,int quantity,int minimumStock,String brand)
    {
        super(id,name,price,quantity,minimumStock);this.brand=brand;
    }
    public String getBrand(){return brand;} public String getType()
    {
        return "Electronic";
    }
}
