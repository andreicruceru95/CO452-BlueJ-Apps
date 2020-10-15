import java.util.ArrayList;
 
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
       for(Product product : stock)
           { 
            if(product.getID() == id) 
                {
                    //replace the name of the product
                    product.replaceName(replacement);
                } 
            }
 
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        for(Product product : stock)
        { 
            if(product.getID() == id) 
            {
                product.increaseQuantity(amount);
            } 
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
                product.getProduct();
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
    public void numberInStock(int id)
    {
        for(Product product : stock)
        { 
            if(product.getID() == id) 
            {
                System.out.println(product.getQuantity());
            }
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (int i = 0; i < stock.size(); i++)
        {
            System.out.println("Product: ");
            stock.get(i).getProduct();
        }
    }
    
    /**
     * Search for a product
     */
    public void searchProduct(String word)
    {
        for (int i = 0; i < stock.size(); i++)
        {
            if (stock.get(i).getName().contains(word))
            {
                stock.get(i).getProduct();
            }
            else
            {
                System.out.println("There is no product with this name");
            }
        }
    }
    
    /**
     * Remove a product out of the stock
     */
    public void removeProduct(int id)
    {
        for (int i = 0; i < stock.size(); i++)
        {
            stock.remove(stock.get(i));
            System.out.println("You have removed ");
            stock.get(i).getProduct();
        }
    }
}
