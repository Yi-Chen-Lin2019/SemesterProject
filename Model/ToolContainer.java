package Model;
import java.util.*;

public class ToolContainer
{
    private ArrayList<Tool> tools;
    
    public ToolContainer()
    {
        tools = new ArrayList<>();
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
