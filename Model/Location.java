package Model;

public class Location
{
    private String depot;
    private String address;
    private String shelf;
    
    public Location(String depot, String address, String shelf)
    {
        this.depot = depot;
        this.address = address;
        this.shelf = shelf;
    }
    
    public String getDepot()
    {
        return depot;
    }
    public String getAddress()
    {
        return address;
    }
    public String getShelf()
    {
        return shelf;
    }
    public void setDepot(String depot)
    {
        this.depot = depot;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setShelf(String shelf)
    {
        this.shelf = shelf;
    }
}
