package Model;
import java.util.*;

public class ItemContainer
{
    private ArrayList<ItemDescriptor> items;
    private static ItemContainer iCon;
    
    private ItemContainer()
    {
        items = new ArrayList<>();
    }
    public static ItemContainer getInstance() {
    	if (iCon==null)
        {
            iCon=new ItemContainer();
        }
        return iCon;
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
