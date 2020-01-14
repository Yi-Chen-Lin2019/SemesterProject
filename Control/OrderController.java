package Control;
import java.util.ArrayList;

import Model.*;

/**
 * OrderController
 *
 * @author Yi-Chen Lin
 * @version 20191215
 */
public class OrderController
{
    private OrderContainer oCon = OrderContainer.getInstance();
    //private CustomerContainer cCon;
    public boolean createOrder(String orderedDate)
    {
        CustomerOrder o = new CustomerOrder(orderedDate);
        oCon.addOrder(o);
        return true;
    }
    
    public GenericOrder findOrder(int orderID)
    {
        GenericOrder o = null;
        for(int i= 0; i < oCon.readOrders().size(); i++)
        {           
            if(oCon.readOrders().get(i).getID() == orderID) {
                o = oCon.readOrders().get(i);
            }
        }
        return o;
    }
    public void printOrder(int orderID)
    {
        if(findOrder(orderID)!=null){
            findOrder(orderID).printOrder();
        }else{
            System.out.println("No such order");
        }
    }  
    public void printAllOrders()
    {
        if(oCon.readOrders().size() !=0) {
            for(int index= 0; index < oCon.readOrders().size(); index++)
            {
                oCon.readOrders().get(index).printOrder();
                System.out.println("____________________\n");    
            }
        }else 
        {
            System.out.println("There are no Orders...");
        }
    }
    public ArrayList<GenericOrder> getAllOrders(){

    		return oCon.readOrders();
    }
 
 
}
