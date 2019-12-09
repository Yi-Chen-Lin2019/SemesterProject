package Model;
import java.util.*;

public class SupplierOrder extends GenericOrder
{
    private SupplierRole supplier;
    private ArrayList<OrderLine> orderLines;
    public SupplierOrder(String orderedDate, String deliveryDate, double totalPrice, EmployeeRole employee, String status, SupplierRole supplier)
    {
        super(orderedDate, deliveryDate, totalPrice, employee, status);
        this.supplier = supplier;
        orderLines = new ArrayList<>();
    }
    
    public SupplierRole getSupplier()
    {
        return supplier;
    }
    public ArrayList<OrderLine> getOrderLines()
    {
        return orderLines;
    }
    public void setSupplier(SupplierRole supplier)
    {
        this.supplier = supplier;
    }
    public void addOrderLine(OrderLine orderLine)
    {
        orderLines.add(orderLine);
    }
    public void removeOrderLine(OrderLine orderLine)
    {
        orderLines.remove(orderLine);
    }
}
