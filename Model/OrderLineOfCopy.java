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
    public int getOrderLineOfCopyNum()
    {
        return orderLineOfCopyNum;
    }


	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
