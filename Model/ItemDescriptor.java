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
    /*public double getSellingPrice()
    {
        return 100000000.0;
    }*/
    public abstract double getSellingPrice();
    public abstract double getCostPrice();
    public abstract int getMinStock();
    public abstract int getMaxStock();
    public abstract double getRecommendedRetailPrice();
    public abstract double getTradeAllowance();
    public abstract int getCategoryID();
}
