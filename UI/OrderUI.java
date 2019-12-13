package UI;
import Control.*;
import java.util.*;

public class OrderUI
{
    private static OrderUI instance;
    private Scanner reader;
    private String inputLine;
    private OrderController oController;
    private OrderLineUI olUI;
    private TextInput reader2 = new TextInput();
    
    private OrderUI()
    {
        oController = OrderController.getInstance();
        olUI = OrderLineUI.getInstance();
        reader = new Scanner(System.in);
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
        System.out.println("Choose an option: ");
        System.out.println("1. Create an order");
        System.out.println("2. Print information about  an order");
        System.out.println("3. Update  an order");
        System.out.println("4. Cancel an order ");
        System.out.println("5. Go back to main menu ");
        while(back == false)
        {
            inputLine = reader.nextLine();
            if(inputLine.equals("1"))
            {
                createOrder();
            }
            else if(inputLine.equals("2"))
            {
                printOrder();
            }
            else if(inputLine.equals("3"))
            {
                updateOrder();
            }
            else if(inputLine.equals("4"))
            {
                cancelOrder();
            }
            else if(inputLine.equals("5"))
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
    public void createOrder()
    {
        System.out.println("Order Added");
        System.out.println("Id of the new order: " + oController.createOrder("now",null,null));
        //To add Employee and Customer need EmployeeController, CustomerController
        //Still need to add Date class
    }
    public void printOrder()
    {
        System.out.println("Feature not implemented yet.");
    }
    public void updateOrder()
    {
        System.out.println("1. Update status");
        System.out.println("2. Manage OrderLines");
        inputLine = reader.nextLine();
            if(inputLine.equals("1"))
            {
                System.out.println("Feature not implemented yet");
            }
            else if(inputLine.equals("2"))
            {
                int orderID = reader2.inputNumber("Order ID:");
                olUI.mainMenu(orderID);
            }
            else
            {
                System.out.println("Please type 1 or 2");
            }
    }
    public void cancelOrder()
    {
        System.out.println("Which order You want to remove?");
        inputLine = reader.nextLine();
        if(oController.cancelOrder(Integer.parseInt(inputLine)))
        {
            System.out.println("Order removed");
        }
        else
        {
            System.out.println("This order doesn't exists");
        }
    }
}
