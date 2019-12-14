package UI;
import Control.*;
import Model.*;

public class OrderLineUI
{
    // instance variables - replace the example below with your own
    private TextInput reader = new TextInput();
    private OrderLineController olCtr = new OrderLineController();
    private static OrderLineUI instance;
    
    /**
     * Constructor for objects of class OrderLineUI
     */
    private OrderLineUI()
    {
        
    }
    
    public static OrderLineUI getInstance()
    {
        if(instance == null)
        {
            instance = new OrderLineUI();
        }
        return instance;
    }

    
    
    private int printOptionsMainMenu()
    {
        /*System.out.print('\u000C');
        System.out.println("..........Order Management .......");
        System.out.println("Options..........................");
        System.out.println("1 Add order line");
        System.out.println("2 Add order line of copy");
        System.out.println("3 Edit order line");
        System.out.println("4 Edit order line of copy");
        System.out.println("5 Remove order line");
        System.out.println("6 Remove order line of copy");
        System.out.println("7 Return");
        System.out.println(".................................");*/
    	TextOptions menu = new TextOptions("\n ***Order Line Menu***", "Return to order menu");
        menu.addOption("Add order line");
        menu.addOption("Add order line of copy");
        menu.addOption("Edit order line");
        menu.addOption("Edit order line of copy");
        menu.addOption("Remove order line");
        menu.addOption("Remove order line of copy");
        return menu.prompt();

    }
    
    

    public void mainMenu(int orderId)
    {
        System.out.print('\u000C');
        boolean finish = false;
        while (!finish)
        {
            //printOptionsMainMenu();
        	int chosenOption= printOptionsMainMenu();
            switch (chosenOption)
            {
                case 1:
                subMenuAddOrderLine(orderId);
                break;
                case 2:
                subMenuAddOrderLineOfCopy(orderId);         
                break;
                case 3:
                System.out.println("Not implemented yet");
                reader.inputString("Press enter to continue...");

                break;
                case 4:                   
                System.out.println("Not implemented yet");  
                reader.inputString("Press enter to continue...");
                break;
                case 5:
                System.out.println("Not implemented yet");  
                reader.inputString("Press enter to continue...");
                break;
                case 6:
                System.out.println("Not implemented yet"); 
                reader.inputString("Press enter to continue...");
                break;                
                default: 
                System.out.println("No legal choice");
                break;
            }
        }

    }
    
    private void subMenuAddOrderLine(int orderId) {  
        String barcode = reader.inputString("Barcode:");
        int quantity = reader.inputNumber("Quantity:");
        if (olCtr.addOrderLine(orderId, barcode, quantity))
        {
            System.out.println("Order line added");
            //sleepMethod(2000);
        }
        else
        {
            System.out.println("Order line could not be added");
            //sleepMethod(2000);
        }
        
    }

    private void subMenuAddOrderLineOfCopy(int orderId) {	
    	String barcode = reader.inputString("Barcode:");
        if (olCtr.addCopyOrderLine(orderId, barcode))
        {
            System.out.println("Order line of copy added");
            //sleepMethod(2000);
        }
        else
        {
            System.out.println("Order line of copy could not be added");
            //sleepMethod(2000);
        }
    }
}
