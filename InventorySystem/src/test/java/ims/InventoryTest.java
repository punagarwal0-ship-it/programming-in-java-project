package ims;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    @Test
    void priceMustBePositive() {
        Product p=new Electronic(1,"Keyboard",500,5,2,"HP");
        assertThrows(IllegalArgumentException.class,()->p.setPrice(0));
    }

    @Test
    void stockCanBeAdded() {
        Product p=new Grocery(2,"Rice",600,5,2,"2027");
        p.addStock(3);
        assertEquals(8,p.getQty());
    }

    @Test
    void saleReducesStock() throws LowStockException {
        Product p=new Electronic(3,"Mouse",300,5,2,"Dell");
        p.sell(2);
        assertEquals(3,p.getQty());
    }

    @Test
    void saleCannotExceedStock() {
        Product p=new Electronic(4,"Monitor",5000,2,1,"Acer");
        assertThrows(LowStockException.class,()->p.sell(3));
    }

    @Test
    void lowStockIsDetected() {
        Product p=new Grocery(5,"Sugar",50,2,2,"2027");
        assertTrue(p.lowStock());
    }
}
