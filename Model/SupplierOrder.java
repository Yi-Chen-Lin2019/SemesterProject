package Model;
import java.util.*;
/**
 * SupplierOrder extends GenericOrder
 *
 * @author Yi-Chen Lin
 * @version 20191215
 */
public class SupplierOrder extends GenericOrder
{
    private SupplierRole supplier;
    private ArrayList<OrderLine> orderLines;
    public SupplierOrder(String orderedDate)
    {
        super(orderedDate);
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
        orderLines.add(orderLine);
        return true;
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
