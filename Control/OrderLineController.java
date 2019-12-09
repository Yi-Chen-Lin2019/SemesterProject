package Control;
import Model.*;
import java.util.*;

public class OrderLineController
{
    private static OrderLineController instance;
    
    private OrderLineController()
    {
        
    }
    
    public static OrderLineController getInstance()
    {
        if(instance == null)
        {
            instance = new OrderLineController();
        }
        return instance;
    }
    
    public OrderLine createOrderLine(int quantity,double price,String barcode)
    {
        OrderLine orderLine = new OrderLine(quantity, price, null); //need ItemController
        return orderLine;
    }
    public OrderLineOfCopy createOrderLineOfCopy(double price,String serialNumber)
    {
        OrderLineOfCopy orderLine = new OrderLineOfCopy(price, null); //need ItemController
        return orderLine;
    }
}