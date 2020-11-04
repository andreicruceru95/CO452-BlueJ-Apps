import java.util.*;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Andrei Cruceru 
 * @version 15102020
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    // A list with data type Product used for calculations.
    List <Product> listClone = new ArrayList<Product>();
    
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }
    
    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Rename a product based on it's id.
     */
    public void renameProduct(int id, String replacement)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            product.replaceName(replacement);
        }
        else
        {
            System.out.println("Product not found!");
        }
    }
       
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            product.increaseQuantity(amount);
        }
        else
        {
            System.out.println("Product not found!");
        }
    }
    
    /**
     * Sell a quantity of a product based on the product's id
     */
    public void sellQuantity(int id,int amount)
    {
        Product product = findProduct(id);
        if (product != null)
        {
            product.sellMultiple(amount);
        }
        else
        {
            System.out.println("Product not found");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        { 
            if(product.getID() == id) 
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public void getQuantity(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            System.out.println(product.getQuantity());        
        }
        else
        {
            System.out.println("Product not found!");
        }
    }
 
    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        stock.forEach(product->
        {
            System.out.println(product.toString());
        });
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            product.sellOne();
            showDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public void getProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
        else
        {
            System.out.println("Product with ID: " + id +
                                " is not recognised.");
        }
    }
    
    /**
     * Search for a product
     */
    public void searchProduct(String word)
    {
        listClone.clear();
        
        for(Product product : stock) 
        { 
            if(product.getName().contains(word))  
            { 
                listClone.add(product);
            }
        }
        
        printClone();
    }
    
    /**
     * Remove a product out of the stock
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            stock.remove(product);        
        }
        
        else
        {
            System.out.println("Product not found!");
        }
    } 
    
    /**
     * Print a list of the products with a quantity lower than 5.
     */
    public void printLowStock()
    {
        listClone.clear();
        
        for (Product product : stock)
        {
            if (product.checkLow() == true)
            {
                listClone.add(product);
            }
        }
        
        System.out.println("The stock of the following products should be refilled");
        printClone();
    }
    
    /**
     * Get delivery for products with low quantity.
     */
    public void refillStock()
    {
        listClone.clear();
        printLowStock();
        
        listClone.forEach(product ->
        {
            product.increaseQuantity(5);    
        });
        
        System.out.println("Refilled the stock for the following products:");
        
        printClone();
    }
    
    /**
     * Print listClone.
     */
    private void printClone()
    {
        listClone.forEach(product ->
        {
            System.out.println(product);
        }); 
    }
}
