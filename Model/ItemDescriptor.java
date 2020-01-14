package Model;

public abstract class ItemDescriptor
{
    private String barcode;
    private String name;

    public ItemDescriptor(String barcode, String name)
    {
        this.barcode = barcode;
        this.name = name;
    }
    public String toString() {
        return  "Name: "+name + "\n Barcode: " + barcode;
    }
    
    public String getBarcode()
    {
        return barcode;
    }
    public String getName()
    {
        return name;
    }
    public void setBarcode(String barcode)
    {
        this.barcode = barcode;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getSellingPrice()
    {
        return 100000000.0;
    }
}
