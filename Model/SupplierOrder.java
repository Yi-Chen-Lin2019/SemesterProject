package Model;
import java.util.*;

public class SupplierOrder extends GenericOrder
{
    private SupplierRole supplier;
    private ArrayList<OrderLine> orderLines;
    public SupplierOrder(String orderedDate, String deliveryDate, EmployeeRole employee, String status, SupplierRole supplier)
    {
        super(orderedDate, deliveryDate, employee, status);
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

	@Override
	public boolean addCopyOrderLine(OrderLineOfCopy oc) {
		// TODO Auto-generated method stub
		return false;
	}
}
