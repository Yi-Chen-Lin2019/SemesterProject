package Model;


public class Tool
{
    private static int id = 0;
    private int toolID;
    private String name;
    private double pricePerDay;
    
    public Tool(String name, double pricePerDay)
    {
        this.toolID = id;
        id++;
        this.name = name;
        this.pricePerDay = pricePerDay;
    }
    
    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public double getPricePerDay()
    {
        return pricePerDay;
    }
    public void setID(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPricePerDay(double pricePerDay)
    {
        this.pricePerDay = pricePerDay;
    }
}
