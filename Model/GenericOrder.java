    package Model;

import java.util.ArrayList;

/**
 * GenericOrder
 *
 * @author Yi-Chen Lin
 * @version 20191215
 */
public abstract class GenericOrder
{
    private static int id = 0;
    private int orderID;
    private String orderedDate;
    private String deliveryAddress;
    private String deliveryDate;
    private double totalPrice;
    private EmployeeRole employee;
    private CustomerRole customer;
    public String status;
    
    
    public GenericOrder(String orderedDate)
    {
        this.orderID = id++;        
        this.orderedDate = orderedDate;
        this.deliveryAddress = null;
        this.deliveryDate = null;
        this.totalPrice = 0.0;
        this.employee = null;
        this.customer = null;
        this.status = "offer";
    }

    public int getID()
    {
        return orderID;
    }
    public String getStatus()
    {
        return status;
    }
    public String getOrderedDate()
    {
        return orderedDate;
    }
    public String getDeliveryDate()
    {
        return deliveryDate;
    }
    public double getTotalPrice()
    {
        return totalPrice;
    }
    /*
    public EmployeeRole getEmployee()
    {
        return employee;        
    }*/
    public void setDeliveryDate(String deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    /*
    public void setEmployee(EmployeeRole employee)
    {
        //this.employee = employee;
    }*/
    public void setStatus(String status)
    {
        this.status = status;
    }

    public abstract boolean addCopyOrderLine(OrderLineOfCopy oc);

    public abstract boolean addOrderLine(OrderLine ol);
    
    //public abstract OrderLine getOrderLine(int orderLineNum);
    //public abstract OrderLineOfCopy getOrderLineOfCopy(int orderLineNum);
    
    public void printOrder()
    {
        System.out.println("Order ID: " + orderID);
        System.out.println("Order date: " + orderedDate);
        System.out.println("Delivery address: " + deliveryAddress);
        System.out.println("Delivery date: "+ deliveryDate);
        System.out.println("Total price: "+ totalPrice);
        System.out.println("Status: "+ status);
    }

	public abstract ArrayList<OrderLine> getOrderLines();
    
}
