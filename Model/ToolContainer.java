package Model;
import java.util.*;

public class ToolContainer
{
    private ArrayList<Tool> tools;
    private static ToolContainer instance;
    
    private ToolContainer()
    {
        tools = new ArrayList<>();
    }

    public static ToolContainer getInstance()
    {
        if(instance == null)
        {
            instance = new ToolContainer();
        }
        return instance;
    }
    public void add(Tool tool)
    {
        tools.add(tool);
    }
    public void remove(Tool tool)
    {
        tools.remove(tool);
    }
    public ArrayList<Tool> read()
    {
        return tools;
    }
}
