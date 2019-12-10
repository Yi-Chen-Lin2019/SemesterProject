package Model;
import java.util.*;

public class KB extends ItemDescriptor
{
    private double price;
    private ArrayList<ItemDescriptor> products;

    public KB(String barcode, String name, double price)
    {
        super(barcode, name);
        this.price = price;
        products = new ArrayList<>();
    }
    public double getSellingPrice()
    {
        return price;
    }
    public ArrayList<ItemDescriptor> getProducts()
    {
        return products;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void addProduct(ItemDescriptor product)
    {
        products.add(product);
    }
    //public double getSellingPrice();
    public double getCostPrice() {return 1;}
    public int getMinStock() {return 1;}
    public int getMaxStock() {retunr 1;}
    public double getRecommendedRetailPrice() {return 1;}
    public double getTradeAllowance() {return 1;}
    public int getCategoryID() {return 1;}
    
}
