package Model;

public class Location
{
    private String department;
    private String address;
    private String shelf;
    
    public Location(String department, String address, String shelf)
    {
        this.department = department;
        this.address = address;
        this.shelf = shelf;
    }
    
    public String getDepartment()
    {
        return department;
    }
    public String getAddress()
    {
        return address;
    }
    public String getShelf()
    {
        return shelf;
    }
}
