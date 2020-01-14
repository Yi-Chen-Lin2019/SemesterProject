package Model;

public class OrderLineOfCopy
{
    private static int number = 1;
    private int orderLineOfCopyNum;
    private double price;
    private Copy copy;
    
    
    public OrderLineOfCopy(Copy copy)
    {
        orderLineOfCopyNum = number++;
        this.copy = copy;
    }
    public int getNum()
    {
        return orderLineOfCopyNum;
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

    public void print() {
        System.out.println("Order Line Of Copy Number: "+ orderLineOfCopyNum);
        System.out.println(copy.toString());
        System.out.println("Price: "+ price);
    }
    
    public int getOrderLineNum()
    {
        return orderLineOfCopyNum;
    }
    
}
