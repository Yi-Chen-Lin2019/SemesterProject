package Model;
import java.util.*;

public class OrderContainer
{
    private ArrayList<GenericOrder> orders;
    private static OrderContainer oCon;
    private OrderContainer()
    {
        orders = new ArrayList<>();
    }
    public static OrderContainer getInstance()
    {
        if (oCon==null)
        {
            oCon=new OrderContainer();
        }
        return oCon;
    }

    public void addOrder(GenericOrder order)
    {
        orders.add(order);
    }
    public void removeOrder(GenericOrder order)
    {
        orders.remove(order);
    }
    public ArrayList<GenericOrder> readOrders()
    {
        return orders;
    }
}
