import java.util.*;

/**
 * Store multiple products until we proceed with payment.
 *
 * @author Andrei Cruceru   
 * @version 04112020
 */
public class ShoppingCart
{
    // instance variables - replace the example below with your own
    List <Product> cart = new ArrayList<Product>();
    private StockManager manager;

    /**
     * Constructor for objects of class ShoppingCart
     */
    public ShoppingCart(StockManager manager)
    {
        this.manager = manager;
    }
    
    /**
     * See a list of available products.
     */
    public void seeProducts()
    {
        manager.printAllProductDetails();
    }
    
    /**
     * Add a product and the quantity you want to buy.
     */
    public void addToCart(int id, int amount)
    {
        Product product = manager.findProduct(id);
        if (product.getQuantity() >= amount)
        {
            cart.add(product);
            product.amountToCart(amount);
        }
        else
        {
            System.out.println("Quantity too high!");
        }
    }    
    
    /**
     * Return the products in the cart.
     */
    public void printCart()
    {
        cart.forEach(product->
        {
            System.out.println("| ID: " + product.getID() + " | Product: " + product.getName() + " | Amount: " + product.getAmount() + " |");
        });
    }
    
    /**
     * Try to find a product in the cart with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    private Product findProduct(int id)
    {
        for(Product product : cart)
        { 
            if(product.getID() == id) 
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Delete a product from cart.
     */
    public void deleteProduct(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            cart.remove(product);        
        }
        
        else
        {
            System.out.println("Product not found in cart!");
        }
    } 
    
    /**
     * Sell the items and empty the cart
     */
    public void proceedWithCart()
    {
        cart.forEach(product->
        {
            manager.sellQuantity(product.getID(), product.getAmount());
            
            System.out.println(product.getAmount() + " " + product.getName() + " Sold");
        });
         
        cart.clear();
    }
}
