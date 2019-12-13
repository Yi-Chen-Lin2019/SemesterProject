package UI;
import Control.*;
import Model.*;

public class OrderLineUI
{
    // instance variables - replace the example below with your own
    private InputRead reader = new InputRead();
    private OrderLineController olCtr = new OrderLineController();
    
    /**
     * Constructor for objects of class OrderLineUI
     */
    public OrderLineUI()
    {
        
    }

    private void sleepMethod(int time)
    {
        try {Thread.sleep(time);
        }
        catch(InterruptedException e){
        }
    }
    
    private void printOptionsMainMenu()
    {
        System.out.print('\u000C');
        System.out.println("..........Order Management .......");
        System.out.println("Options..........................");
        System.out.println("1 Add order line (timber)");
        System.out.println("2 Add order line of copy");
        System.out.println("3 Edit order line (timber)");
        System.out.println("4 Edit order line of copy");
        System.out.println("5 Remove order line (timber)");
        System.out.println("6 Remove order line of copy");
        System.out.println("7 Return");
        System.out.println(".................................");

    }
    

    public void mainMenu(int orderId)
    {
        System.out.print('\u000C');
        String chosenOption="0";
        while (chosenOption!="7")
        {
            printOptionsMainMenu();
            chosenOption= reader.readText(">");
            switch (chosenOption)
            {
                case "1":
                subMenuAddOrderLine(orderId);
                break;
                case "2":
                subMenuAddOrderLineOfCopy(orderId);         
                break;
                case "3":
                System.out.println("Need help here");
                reader.readText("Press enter to continue...");

                break;
                case "4":                   
                System.out.println("Need help here");  
                reader.readText("Press enter to continue...");
                break;
                case "5":
                System.out.println("Need help here");  
                reader.readText("Press enter to continue...");
                break;
                case "6":
                System.out.println("Need help here"); 
                reader.readText("Press enter to continue...");
                break;
                case "7":
                chosenOption="7";
                break;
                
                default: 
                System.out.println("No legal choice");
                break;
            }
        }

    }
    
    private void subMenuAddOrderLine(int orderId) {  
        String barcode = reader.readText("Barcode:");
        int quantity = reader.readInt("Quantity:");
        if (olCtr.addOrderLine(orderId, barcode, quantity))
        {
            System.out.println("Order line added");
            sleepMethod(2000);
        }
        else
        {
            System.out.println("Order line could not be added");
            sleepMethod(2000);
        }
        
    }

    private void subMenuAddOrderLineOfCopy(int orderId) {	
    	String barcode = reader.readText("Barcode:");
        if (olCtr.addCopyOrderLine(orderId, barcode))
        {
            System.out.println("Order line of copy added");
            sleepMethod(2000);
        }
        else
        {
            System.out.println("Order line of copy could not be added");
            sleepMethod(2000);
        }
    }
}
