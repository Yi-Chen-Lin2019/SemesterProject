package Model;

public class OrderLineOfCopy
{
    private double price;
    private Copy copy;
    
    public OrderLineOfCopy(double price, Copy copy)
    {
        this.price = price;
        this.copy = copy;
    }

    public double getPrice()
    {
        return price;
    }
    public Copy getCopy()
    {
        return copy;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setCopy(Copy copy)
    {
        this.copy = copy;
    }
}
