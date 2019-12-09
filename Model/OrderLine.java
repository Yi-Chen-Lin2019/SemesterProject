package Model;

public class OrderLine
{
    private int quantity;
    private double price;
    private ItemDescriptor item;
    
    public OrderLine(int quantity, double price, ItemDescriptor item)
    {
        this.quantity = quantity;
        this.price = price;
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
}
