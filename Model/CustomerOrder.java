package Model;


import java.util.*;
/**
 * CustomerOrder extends GenericOrder
 *
 * @author Yi-Chen Lin
 * @version 20191215
 */
public class CustomerOrder extends GenericOrder
{
    private String shipDate;
    private CustomerRole customer;
    private ArrayList<OrderLine> orderLines;
    private ArrayList<OrderLineOfCopy> copyOrderLines;
    
    public CustomerOrder(String orderedDate)
    {
        super(orderedDate);
        //this.customer = customer;
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
    public String getShippedDate()
    {
        return shipDate;
    }
    public void setShippedDate(String shippedDate)
    {
        this.shipDate = shipDate;
    }
    public boolean addOrderLine(OrderLine orderLine)
    {
        if(orderLine != null) {
            orderLines.add(orderLine);
            setPrice();
            return true;
        }else {
            return false;
        }
    }
    public void removeOrderLine(OrderLine orderLine)
    {
        orderLines.remove(orderLine);
    }
    public boolean addCopyOrderLine(OrderLineOfCopy orderLineOfCopy)
    {
        if(orderLineOfCopy != null) {   
            copyOrderLines.add(orderLineOfCopy);
            setPrice();
            return true;
        }else {
            return false;
        }
    }
    public void removeCopyOrderLine(OrderLineOfCopy orderLineOfCopy)
    {
        copyOrderLines.remove(orderLineOfCopy);
    }
    
    public void printOrder()
    {
        super.printOrder();
        System.out.println("Ship date: "+ shipDate);
        System.out.println("");
        System.out.println("> Order line: ");
        for(int index = 0; index < orderLines.size(); index++) {
            orderLines.get(index).print();
        }
        System.out.println("");
        System.out.println("> Order line of copy: ");
        for(int index = 0; index < copyOrderLines.size(); index++) {
            copyOrderLines.get(index).print();
        }
        System.out.println("");
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
    
    public OrderLine getOrderLine(int orderLineNum)
    {
        OrderLine ol = null;
        for(int i = 0; i< orderLines.size(); i++){
            if(orderLines.get(i).getOrderLineNum()== orderLineNum){
                ol = orderLines.get(i);
            }
        }
        return ol;
    }
    
    public OrderLineOfCopy getOrderLineOfCopy(int orderLineOfCopyNum)
    {
        OrderLineOfCopy olc = null;
        for(int i = 0; i< copyOrderLines.size(); i++){
            if(copyOrderLines.get(i).getOrderLineNum()== orderLineOfCopyNum){
                olc = copyOrderLines.get(i);
            }
        }
        return olc;
    }
}
