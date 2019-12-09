package Model;
import java.util.*;

public class ItemContainer
{
    private ArrayList<ItemDescriptor> items;
    private static ItemContainer instance;
    
    private ItemContainer()
    {
        items = new ArrayList<>();
    }

    public static ItemContainer getInstance()
    {
        if(instance == null)
        {
            instance = new ItemContainer();
        }
        return instance;
    }
    public void add(ItemDescriptor item)
    {
        items.add(item);
    }
    public void remove(ItemDescriptor item)
    {
        items.remove(item);
    }
    public ArrayList<ItemDescriptor> read()
    {
        return items;
    }
}
