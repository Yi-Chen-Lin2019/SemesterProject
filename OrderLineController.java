package Control;


import Model.*;



public class OrderLineController
{
    private static OrderLineController instance;
    
    private OrderLineController()
    {
    }
    
    public static OrderLineController getInstance()
    {
        if(instance == null)
        {
            instance = new OrderLineController();
        }
        return instance;
    }
    public boolean addOrderLine(int orderId, String barcode, int quantity)
    {
        OrderController oCtr = OrderController.getInstance();
        GenericOrder order = oCtr.findOrder(orderId);
        if (order == null)
        {
            return false;
            // This should not happen if we had chosen an existing order
        }
        
        // Get the relevant itemdescriptor: Cooperation with the itemdescriptor controller
        ItemController iCtr = new ItemController();
        ItemDescriptor item =iCtr.getItem(barcode);
        if (item == null)
        {
            return false;
        }
        // Create new suborder and link it to the found item descriptor
        OrderLine ol= new OrderLine(quantity,0, item);
        // Insert this suborder in the found order
        order.addOrderLine(ol);
        return true;
    }
    
    public boolean addCopyOrderLine(int orderId, String barcode)
    {
        OrderController oCtr = new OrderController();
        GenericOrder order = oCtr.findOrder(orderId);
        if (order == null)
        {
            System.out.println("Error here");
            return false;
            // This should not happen if we had chosen an existing order
        }
        
        // Get the relevant itemdescriptor: Cooperation with the itemdescriptor controller
        ItemController iCtr = new ItemController();
        Copy copy = iCtr.getCopy(barcode);
        if (copy == null)
        {
            System.out.println("Error here2");
            return false;
        }
        // Create new suborder and link it to the found item descriptor
        OrderLineOfCopy oc= new OrderLineOfCopy(0,copy);
        oc.setPrice(iCtr.getItem(barcode).getSellingPrice());
        // Insert this suborder in the found order
        order.addCopyOrderLine(oc);
        return true;
    }
    
    public boolean editOrderLine(int orderId, String barcode, int quantity)
    {
        OrderController oCtr = new OrderController();
        GenericOrder order = oCtr.findOrder(orderId);
        if (order == null)
        {
            return false;
            // This should not happen if we had chosen an existing order
        }
  
        // Get the relevant itemdescriptor: Cooperation with the itemdescriptor controller
        ItemController iCtr = new ItemController();
        ItemDescriptor item =iCtr.getItem(barcode);
        if (item == null)
        {
            return false;
        }
        // Create new suborder and link it to the found item descriptor
        OrderLine ol= new OrderLine(quantity,0, item);
        // Insert this suborder in the found order
        order.addOrderLine(ol);
        return true;
    }
    
    /*
    public boolean removeOrderLine(int orderId, int orderLineNum)
    {
        OrderController oCtr = new OrderController();
        GenericOrder order = oCtr.findOrder(orderId);
        if (order == null)
        {
            System.out.println("Error");
            return false;
            // This should not happen if we had chosen an existing order
        }
        order = (CustomerOrder) order;
        if(order.getOrderLine(orderLineNum)==null){
            return false;
        }
        order.remove(order.getOrderLine(orderLineNum));
        return true;
    }
    public boolean removeCopyOrderLine(OrderLineOfCopy orderLineOfCopy)
    {
    OrderController oCtr = new OrderController();
        GenericOrder order = oCtr.findOrder(orderId);
        if (order == null)
        {
            System.out.println("Error");
            return false;
            // This should not happen if we had chosen an existing order
        }
        
        if(order.getOrderLine(orderLineNum)==null){
            return false;
        }
        order.remove(order.getOrderLine(orderLineNum));
        return true;
    
    }
    */
   
    
    
    
    
    
    
}
