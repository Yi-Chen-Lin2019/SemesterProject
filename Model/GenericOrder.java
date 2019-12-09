package Model;
import java.util.*;

public abstract class GenericOrder
{
    private static int id = 0;
    private int orderID;
    private String orderedDate;
    private String deliveryDate;
    private double totalPrice;
    private EmployeeRole employee;
    public String status;
    
    public GenericOrder(String orderedDate, String deliveryDate, double totalPrice, EmployeeRole employee, String status)
    {
        this.orderID = id;
        id++;
        this.orderedDate = orderedDate;
        this.deliveryDate = deliveryDate;
        this.totalPrice = totalPrice;
        this.employee = employee;
        this.status = status;
    }

    public int getOrderID()
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
    public EmployeeRole getEmployee()
    {
        return employee;
    }
    public void setDeliveryDate(String deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    public void setEmployee(EmployeeRole employee)
    {
        this.employee = employee;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
}
