package Model;
import java.util.*;

public class CustomerOrder extends GenericOrder
{
    private CustomerRole customer;
    private ArrayList<OrderLine> orderLines;
    private ArrayList<OrderLineOfCopy> copyOrderLines;
    public CustomerOrder(String orderedDate, String deliveryDate, double totalPrice, EmployeeRole employee, String status, CustomerRole customer)
    {
        super(orderedDate, deliveryDate, totalPrice, employee, status);
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
    public void addOrderLine(OrderLine orderLine)
    {
        orderLines.add(orderLine);
    }
    public void removeOrderLine(OrderLine orderLine)
    {
        orderLines.remove(orderLine);
    }
    public void addCopyOrderLine(OrderLineOfCopy orderLine)
    {
        copyOrderLines.add(orderLine);
    }
    public void removeCopyOrderLine(OrderLineOfCopy orderLine)
    {
        copyOrderLines.remove(orderLine);
    }
}
