package UI;
import Control.*;
import Model.*;

import java.util.*;

public class OrderUI
{
    private static OrderUI instance;
    private String inputLine;
    private OrderController oController;
    private OrderLineUI olUI;
    private TextInput reader = new TextInput();
    
    
    private OrderUI()
    {
        oController = OrderController.getInstance();
        olUI = OrderLineUI.getInstance();
        //reader = new Scanner(System.in);
        inputLine = "";
    }

    public static OrderUI getInstance()
    {
        if(instance == null)
        {
            instance = new OrderUI();
        }
        return instance;
    }
    public void main()
    {
        boolean back = false;
        /*
        System.out.println("Choose an option: ");
        System.out.println("1. Create an order");
        System.out.println("2. Print information about  an order");
        System.out.println("3. Update  an order");
        System.out.println("4. Cancel an order ");
        System.out.println("5. Go back to main menu ");
        */
        while(back == false)
        {
            int inputLine = writeOrderMenu();
            if(inputLine == 1)
            {
                createOrder();
            }
            else if(inputLine ==2)
            {
                printOrder();
            }
            else if(inputLine == 3)
            {
                updateOrder();
            }
            else if(inputLine == 4)
            {
                cancelOrder();
            }
            else if(inputLine == 5)
            {
                back = true;
            }
            else
            {
                System.out.println(inputLine);
                System.out.println("Please input 1,2,3,4 or 5");
            }
        }
        
    }
    private int writeOrderMenu(){
        TextOptions menu = new TextOptions("\n ***Order Menu***", "Go back to main menu");
        menu.addOption("Create an order");
        menu.addOption("Print information about  an order");
        menu.addOption("Update  an order");
        menu.addOption("Cancel an order");
        return menu.prompt();
    }
    public void createOrder()
    {
        System.out.println("Order Added");
        System.out.println("Id of the new order: " + oController.createOrder("now",null,null));
        //To add Employee and Customer need EmployeeController, CustomerController
        //Still need to add Date class
    }
    public void printOrder()
    {
    	System.out.println("Which Order do you want to print?");
        int id = reader.inputNumber(">");
        CustomerOrder order = oController.findOrder(id);
        if(order == null) {
        	System.out.println("Wrong ID, try again");
        }
        else {
        	
	        System.out.println("Total price: " + order.getTotalPrice());
	        System.out.println("Order line: ");
	        for(OrderLine line : order.getOrderLines())
	        {
	            System.out.println("quantity: " +line.getQuantity());
	            System.out.println("price: " +line.getPrice());
	            System.out.println("product: " +line.getItem().getName());
	        }
	        System.out.println("Order line of copy: ");
	        for(OrderLineOfCopy line : order.getCopyOrderLines())
	        {
	            System.out.println("price: " +line.getPrice());
	            System.out.println("Serial Number: " +line.getCopy().getSerialNumber());
	        }
        }
    }
    public void updateOrder()
    {
        System.out.println("1. Update status");
        System.out.println("2. Manage OrderLines");
        String number = reader.inputString("Choose a number");
            if(number.equals("1"))
            {
                System.out.println("Feature not implemented yet");
            }
            else if(number.equals("2"))
            {
            	System.out.println("Which Order do you want to manage?");
            	int orderID = reader.inputNumber("Order ID:");
            	CustomerOrder order = oController.findOrder(orderID);
                if(order == null) {
                	System.out.println("Wrong ID, try again");
                }
                while(order != null) {
                	olUI.mainMenu(orderID);
                }
            }
            else
            {
                System.out.println("Please type 1 or 2");
            }
    }
    public void cancelOrder()
    {
        System.out.println("Which order You want to remove?");
        int choice = reader.inputNumber(">");
        if(oController.cancelOrder(choice))
        {
            System.out.println("Order removed");
        }
        else
        {
            System.out.println("This order doesn't exists");
        }
    }
}
