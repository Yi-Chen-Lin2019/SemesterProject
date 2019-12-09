package Model;


public class LocationLine
{
    private int quantity;
    private Location location;
    
    public LocationLine(int quantity,Location location)
    {
        this.quantity = quantity;
        this.location = location;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    public Location getLocation()
    {
        return location;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
