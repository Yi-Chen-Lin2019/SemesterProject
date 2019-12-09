package UI;
import Control.*;
import java.util.*;

public class OrderLineUI
{
    private static OrderLineUI instance;
    private Scanner reader;
    private String inputLine;
    private OrderLineController olController;
    
    private OrderLineUI()
    {
        reader = new Scanner(System.in);
        inputLine = "";
        olController = OrderLineController.getInstance();
    }

    public static OrderLineUI getInstance()
    {
        if(instance == null)
        {
            instance = new OrderLineUI();
        }
        return instance;
    }
    public void main()
    {
        boolean back = false;
        System.out.println("1. Add order line");
        System.out.println("2. Add order line of copy");
        System.out.println("3. Edit order line");
        System.out.println("4. Edit order line of copy");
        System.out.println("5. Remove order line");
        System.out.println("6. Remove order line of copy");
        System.out.println("7. back");
        while(back == false)
        {
            inputLine = reader.nextLine();
            if(inputLine.equals("1"))
            {
                addOrderLine();
            }
            else if(inputLine.equals("2"))
            {
                addOrderLineOfCopy();
            }
            else if(inputLine.equals("3"))
            {
                editOrderLine();
            }
            else if(inputLine.equals("4"))
            {
                editOrderLineOfCopy();
            }
            else if(inputLine.equals("5"))
            {
                removeOrderLine();
            }
            else if(inputLine.equals("6"))
            {
                removeOrderLineOfCopy();
            }
            else if(inputLine.equals("7"))
            {
                back = true;
            }
            else
            {
                System.out.println(inputLine);
                System.out.println("Please input 1,2,3,4,5,6 or 7");
            }
        }
    }
    public void addOrderLine()
    {
        System.out.println("Feature not implemented yet");
    }
    public void addOrderLineOfCopy()
    {
        System.out.println("Feature not implemented yet");
    }
    public void editOrderLine()
    {
        System.out.println("Feature not implemented yet");
    }
    public void editOrderLineOfCopy()
    {
        System.out.println("Feature not implemented yet");
    }
    public void removeOrderLine()
    {
        System.out.println("Feature not implemented yet");
    }
    public void removeOrderLineOfCopy()
    {
        System.out.println("Feature not implemented yet");
    }
}
