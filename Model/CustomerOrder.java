package Model;
import java.util.*;

public class CustomerOrder extends GenericOrder
{
    private CustomerRole customer;
    private ArrayList<OrderLine> orderLines;
    private ArrayList<OrderLineOfCopy> copyOrderLines;
    public CustomerOrder(String orderedDate, String deliveryDate, EmployeeRole employee, String status, CustomerRole customer)
    {
        super(orderedDate, deliveryDate, employee, status);
        this.customer = customer;
        orderLines = new ArrayList<>();
        copyOrderLines = new ArrayList<>();
    }
    
    public CustomerRole getCustomer()
    {
        return customer;
    }
    public ArrayList<OrderLine> getOrderLines()
    {
        return orderLines;
    }
    public ArrayList<OrderLineOfCopy> getCopyOrderLines()
    {
        return copyOrderLines;
    }
    public void setCustomer(CustomerRole customer)
    {
        this.customer = customer;
    }
    public boolean addOrderLine(OrderLine orderLine)
    {
        if(orderLine !=null) {
        	orderLines.add(orderLine);
        	return true;
        }else {
        	return false;
        }
    }
    public void removeOrderLine(OrderLine orderLine)
    {
        orderLines.remove(orderLine);
    }
    public boolean addCopyOrderLine(OrderLineOfCopy orderLine)
    {
        if(orderLine !=null) {
        	copyOrderLines.add(orderLine);
        	return true;
        }else {
        	return false;
        }
    }
    public void removeCopyOrderLine(OrderLineOfCopy orderLine)
    {
        copyOrderLines.remove(orderLine);
    }
    public void setPrice()
    {
        double newPrice = 0;
        for(int index = 0; index < orderLines.size(); index++) {
            double price = orderLines.get(index).getPrice();
            newPrice += price;
        }
        for(int index = 0; index < copyOrderLines.size(); index++) {
            double price = copyOrderLines.get(index).getPrice();
            newPrice += price;
        }
        super.setTotalPrice(newPrice);
    }
}
