import java.util.*;
import java.io.*;
import java.lang.management.*;
import java.text.*;
import java.util.*;
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author Andrei Cruceru 
 * @version 07102020
 */
public class TicketMachine
{
    // The amount of money entered by a customer so far.
    private int price;
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // The list of tickets
    private Ticket ticket;
    private ArrayList<Ticket> aListTicket = new ArrayList<Ticket>();
    private Coin coin;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
    }
    
    public void selectTicketToBuy(Ticket newTicket)
    {
        
    }
    
    public ArrayList getTickets()
    {
        return aListTicket;
    }
    
     /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(Coin coin)
    {
        this.coin=coin;
        balance = balance + coin;
        System.out.println("You just inserted " + coin + "!");
        System.out.println("You need another " + price - balance + "!");
        
    }
    
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
