package Model;

public class OrderLine extends GenericOL
{
    private static int number = 1;
    private int orderLineNum;
    private int quantity;
    private double price;
    private ItemDescriptor item;
    
    public OrderLine(int quantity, ItemDescriptor item)
    {
        this.orderLineNum = number++;
        this.quantity = quantity;
        this.price = item.getSellingPrice()*quantity;
        this.item = item;
    }
    public int getNum()
    {
        return orderLineNum;
    }

    public int getQuantity()
    {
        return quantity;
    }
    public double getPrice()
    {
        return price;
    }
    public ItemDescriptor getItem()
    {
        return item;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setItem(ItemDescriptor item)
    {
        this.item = item;
    }
    public void print()
    {
        System.out.println("Order Line Number: "+ orderLineNum);
        System.out.println("Name: "+ item.getName());
        System.out.println("Barcode: "+ item.getBarcode());
        System.out.println("Quantity: "+ quantity);
        System.out.println("Price: "+ price);
    }
    public int getOrderLineNum()
    {
        return orderLineNum;
    }
	@Override
	public String getDescription() {
		return item.getName();
	}
    
}
