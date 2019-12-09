package Model;
import java.util.*;

public class SupplierContainer
{
    private ArrayList<SupplierRole> suppliers;
    private static SupplierContainer instance;
    
    private SupplierContainer()
    {
        suppliers = new ArrayList<>();
    }

    public static SupplierContainer getInstance()
    {
        if(instance == null)
        {
            instance = new SupplierContainer();
        }
        return instance;
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
