package Model;

public class OrderLine
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
        this.price = item.getSellingPrice();
        this.item = item;
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
    public int getOrderLineNum()
    {
        return orderLineNum;
    }
}
