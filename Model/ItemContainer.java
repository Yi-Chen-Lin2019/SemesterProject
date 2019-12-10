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
    
    public void saveItem()
    {
        String outString;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Products.txt"));
            // Write these lines to the file.
            // ... We call newLine to insert a newline character.
            try {
                outString = String.format("%d",items.size());
                writer.write(outString);
                writer.newLine();
            }
            catch (Exception e) {

            }
            for (ItemDescriptor item : items) {

                try {
                    writer.write(item.getBarcode());
                    writer.newLine();
                    writer.write(item.getName());
                    writer.newLine();
                    outString = String.format("%d",item.getCategoryID());
                    writer.write(outString);
                    writer.newLine();
                    outString = String.format("%d",item.getMinStock());
                    writer.write(outString);
                    writer.newLine();
                    outString = String.format("%d",item.getMaxStock());
                    writer.write(outString);
                    writer.newLine();
                    outString = String.format("%d",item.getRecommendedRetailPrice());
                    writer.write(outString);
                    writer.newLine();
                    outString = String.format("%d",item.getTradeAllowance());
                    writer.write(outString);
                    writer.newLine();
                    outString = String.format("%d",item.getCostPrice());
                    writer.write(outString);
                    writer.newLine();
                    outString = String.format("%d",item.getSellingPrice());
                    writer.write(outString);
                    writer.newLine();
                }
                catch (Exception e) {

                }
            }
            writer.flush();
        }
        catch (Exception e) {

        }

    }
}
