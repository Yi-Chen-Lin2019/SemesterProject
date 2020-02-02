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
    public String toString() {
        return super.toString() + "\n Price: " + price;
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
    
}
