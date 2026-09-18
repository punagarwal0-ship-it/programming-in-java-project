
import java.io.*; import java.lang.reflect.Field; import java.nio.file.*; import java.util.*;
public class Inventory {
    private final TreeMap<Integer,Product> products=new TreeMap<>(); private final ArrayList<Supplier> suppliers=new ArrayList<>();
    private final Path productFile=Paths.get("data","inventory.txt"), supplierFile=Paths.get("data","suppliers.txt"), historyFile=Paths.get("data","stock_history.txt");

    public Inventory(){
        load();}

    public void addProduct(Product p){
        if(products.containsKey(p.getId()))throw new IllegalArgumentException("Product ID already exists.");
        products.put(p.getId(),p);
        save();}

    private Product get(int id){Product p=products.get(id);if(p==null)throw new IllegalArgumentException("Product not found.");return p;}

    public void showProducts(){if(products.isEmpty()){System.out.println("No products available.");return;}System.out.println("\nID    Name                 Type         Price      Stock    Min Stock");System.out.println("---------------------------------------------------------------------");products.values().forEach(System.out::println);}

    public void search(String s){boolean f=false;for(Product p:products.values())if(p.getName().toLowerCase().contains(s.toLowerCase())||p.getType().toLowerCase().contains(s.toLowerCase())){System.out.println(p);f=true;}if(!f)System.out.println("No matching products found.");}

    public void updatePrice(int id,double price){get(id).setPrice(price);save();System.out.println("Price updated.");}

    public void addStock(int id,int n){Product p=get(id);p.addStock(n);log("ADDED "+n+" units to product "+id);save();System.out.println("Current stock: "+p.getQuantity());}

    public void sell(int id,int n)throws LowStockException{Product p=get(id);p.sell(n);log("SOLD "+n+" units of product "+id);save();System.out.println("Current stock: "+p.getQuantity());}

    public void delete(int id){if(products.remove(id)==null)throw new IllegalArgumentException("Product not found.");save();System.out.println("Product deleted.");}

    public void lowStock(){boolean f=false;for(Product p:products.values())if(p.isLowStock()){System.out.println(p);f=true;}if(!f)System.out.println("No low-stock products.");}

    public void addSupplier(Supplier s){for(Supplier x:suppliers)if(x.getId()==s.getId())throw new IllegalArgumentException("Supplier ID already exists.");suppliers.add(s);saveSuppliers();}

    public void showSuppliers(){if(suppliers.isEmpty()){System.out.println("No suppliers available.");return;}suppliers.forEach(System.out::println);}

    public void report(){int units=0,low=0;double value=0;for(Product p:products.values()){units+=p.getQuantity();value+=p.getQuantity()*p.getPrice();if(p.isLowStock())low++;}System.out.printf("\n===== INVENTORY REPORT =====%nProducts: %d%nTotal units: %d%nStock value: %.2f%nLow-stock items: %d%nSuppliers: %d%n",products.size(),units,value,low,suppliers.size());}

    public void reflection(){System.out.println("\nProduct fields using Reflection:");for(Field f:Product.class.getDeclaredFields())System.out.println("- "+f.getName()+" ("+f.getType().getSimpleName()+")");}

    public void history(){try{if(!Files.exists(historyFile)){System.out.println("No stock history yet.");return;}Files.lines(historyFile).forEach(System.out::println);}catch(IOException e){System.out.println("Could not read history.");}}

    private void log(String s){try{Files.createDirectories(historyFile.getParent());Files.writeString(historyFile,new Date()+" - "+s+System.lineSeparator(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);}catch(IOException ignored){}}

    private void save(){try{Files.createDirectories(productFile.getParent());try(BufferedWriter w=Files.newBufferedWriter(productFile)){for(Product p:products.values()){String extra=p instanceof Electronic e?e.getBrand():p instanceof Grocery g?g.getExpiryDate():"";w.write(p.getType()+"|"+p.getId()+"|"+p.getName().replace("|","/")+"|"+p.getPrice()+"|"+p.getQuantity()+"|"+p.getMinimumStock()+"|"+extra.replace("|","/"));w.newLine();}}}catch(IOException e){System.out.println("Warning: could not save inventory.");}}

    private void saveSuppliers(){try{Files.createDirectories(supplierFile.getParent());try(BufferedWriter w=Files.newBufferedWriter(supplierFile)){for(Supplier s:suppliers){w.write(s.getId()+"|"+s.getName().replace("|","/")+"|"+s.getPhone().replace("|","/"));w.newLine();}}}catch(IOException e){System.out.println("Warning: could not save suppliers.");}}

    private void load(){try{if(Files.exists(productFile))for(String l:Files.readAllLines(productFile)){String[]x=l.split("\\|",-1);if(x.length<7)continue;int id=Integer.parseInt(x[1]);double pr=Double.parseDouble(x[3]);int q=Integer.parseInt(x[4]),m=Integer.parseInt(x[5]);products.put(id,x[0].equals("Electronic")?new Electronic(id,x[2],pr,q,m,x[6]):new Grocery(id,x[2],pr,q,m,x[6]));}if(Files.exists(supplierFile))for(String l:Files.readAllLines(supplierFile)){String[]x=l.split("\\|",-1);if(x.length>=3)suppliers.add(new Supplier(Integer.parseInt(x[0]),x[1],x[2]));}}catch(Exception e){System.out.println("Warning: saved data could not be loaded.");}}
}
