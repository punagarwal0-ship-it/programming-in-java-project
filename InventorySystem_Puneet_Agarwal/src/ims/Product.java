package ims;
public abstract class Product {
    private int id; private String name; private double price; private int quantity; private int minimumStock;
    public Product(int id,String name,double price,int quantity,int minimumStock){setId(id);setName(name);setPrice(price);setQuantity(quantity);setMinimumStock(minimumStock);}
    public int getId(){return id;} public String getName(){return name;} public double getPrice(){return price;} public int getQuantity(){return quantity;} public int getMinimumStock(){return minimumStock;}
    public void setId(int v){if(v<=0)throw new IllegalArgumentException("ID must be positive.");id=v;}
    public void setName(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Name cannot be empty.");name=v;}
    public void setPrice(double v){if(v<0)throw new IllegalArgumentException("Price cannot be negative.");price=v;}
    public void setQuantity(int v){if(v<0)throw new IllegalArgumentException("Quantity cannot be negative.");quantity=v;}
    public void setMinimumStock(int v){if(v<0)throw new IllegalArgumentException("Minimum stock cannot be negative.");minimumStock=v;}
    public void addStock(int v){if(v<=0)throw new IllegalArgumentException("Stock amount must be positive.");quantity+=v;}
    public void sell(int v)throws LowStockException{if(v<=0)throw new IllegalArgumentException("Sale quantity must be positive.");if(v>quantity)throw new LowStockException("Not enough stock available.");quantity-=v;}
    public boolean isLowStock(){return quantity<=minimumStock;}
    public abstract String getType();
    public String toString(){return String.format("%-5d %-20s %-12s %-10.2f %-8d %-10d",id,name,getType(),price,quantity,minimumStock);}
}