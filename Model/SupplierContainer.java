package Model;
import java.util.*;

public class SupplierContainer
{
    private ArrayList<SupplierRole> suppliers;
    
    public SupplierContainer()
    {
        suppliers = new ArrayList<>();
    }

    public void add(SupplierRole supplier)
    {
        suppliers.add(supplier);
    }
    public void remove(SupplierRole supplier)
    {
        suppliers.remove(supplier);
    }
    public ArrayList<SupplierRole> read()
    {
        return suppliers;
    }
}
