package Model;


public class Copy
{
    private String serialNumber;
    

    public Copy(String serialNumber)
    {
        this.serialNumber = serialNumber;
        
    }
    public String toString() {
        return "\n Serial Number: " + serialNumber;
    }    
    
    public String getSerialNumber()
    {
        return serialNumber;
    }
    
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }
    
}
