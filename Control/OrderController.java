package Control;
import java.util.ArrayList;
import java.util.Iterator;

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
    {	boolean finish = false;
    	if(orderedDate!=null) {
	    	CustomerOrder o = new CustomerOrder(orderedDate);
	        oCon.addOrder(o);
	        finish = true;
        }
        return finish;
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
    
    
    public ArrayList<OrderLine> getOrderLines(int orderId){
    	ArrayList<OrderLine> result = null;
    	GenericOrder order = findOrder(orderId);
    	if(order !=null && order instanceof CustomerOrder) {
    		result = order.getOrderLines();
    	}
    	return result;
    }
    
    public ArrayList<OrderLineOfCopy> getOrderLinesOfCopy(int orderId){
    	ArrayList<OrderLineOfCopy> result = null;
    	GenericOrder order = findOrder(orderId);
    	if(order !=null && order instanceof CustomerOrder) {
    		result = ((CustomerOrder) order).getCopyOrderLines();
    	}
    	return result;
    }
    
    public ArrayList<GenericOL> getTest(int orderId){
    	ArrayList<GenericOL> result = new ArrayList<>();
    	GenericOrder order = findOrder(orderId);
    	if(order !=null && order instanceof CustomerOrder) {
    		Iterator<OrderLine> i =  ((CustomerOrder) order).getOrderLines().iterator();
    		while(i.hasNext()) {
    			OrderLine ol= (OrderLine) i.next();
    			result.add(ol);
    		}
    		Iterator<OrderLineOfCopy> it =  ((CustomerOrder) order).getCopyOrderLines().iterator();
    		while(it.hasNext()) {
    			OrderLineOfCopy copyOL = (OrderLineOfCopy) it.next();
    			result.add(copyOL);
    		}   		
    	}
    	return result;
    }
 
}
