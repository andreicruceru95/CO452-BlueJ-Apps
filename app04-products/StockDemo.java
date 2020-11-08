import java.util.*;

/**
 * 
 * Demonstrate the StockManager and Product classes.
 * 
 * @author Andrei Cruceru.
 * @version 15102020
 */
public class StockDemo
{
    // The stock manager and the items list.
    private StockManager manager;
    private String[] items = new String[]{"Bush Clock Radio ","Google Pixel 4XL ","Samsung QLED TV  ","IKEA Malm Desk   ", "Japanese Storage ",
                    "Samsung Microwave" , "Monda Table Lamp ","Washing Mashine  ","Bosch S. 4 Dryer ","Beko Elect Cooker","IKEA Ektorp Sofa " ,
                     "Shower Curtain   ","Krau Kitchen Sink"}; 
    
    // A generator of random numbers.
    private Random generator;
    
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     * Demonstrate the program can deliver products and sell products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
            
        generator = new Random();
                
        header();
        addProducts();
                            
        printMessage("delivering products");
        deliverProducts();
        
        printMessage("selling products");
        sellProducts();
    }
    
    /**
     * Demonstrate the deliver products method.
     */
    private void addProducts()
    {
        int j = 0;
        
        for (int i = 21; i <= 33; i++)
        {
            manager.addProduct(new Product(i, items[j]));
            j++;
        }
            
        manager.printAllProductDetails();     
    }
    
    /**
     * Demonstrate the deliver products method.
     */
    private void deliverProducts()
    {
        // Deliver a random number of products.
        int amount = 0;
       
        for(int i=21; i <= 33; i++)
        {
            amount = generator.nextInt(15) + 1;
            
            manager.deliverProduct(i, amount);            
        }
        
    }
    
    /**
     * Demonstrate the sell products method.
     */
    private void sellProducts()
    {
        // Deliver a random number of products.
        int amount = 0;
       
        for(int i=21; i <= 33; i++)
        {
            amount = generator.nextInt(10) + 1;
            
            manager.sellMultiple(i, amount);            
        }
    
    }
    
    /**
     * Print a message for each method on the terminal.
     */
    private void printMessage(String method)
    {
        System.out.println();
        System.out.println("Demonstrating " + method);
        System.out.println();
        
    }
    
    private void header()
    {
        System.out.println();
        System.out.println("##############");
        System.out.println("Andrei's stock");
        System.out.println("**************");
        System.out.println();
    }
}
