package Model;
import java.util.*;

public class EmployeeContainer
{
    private ArrayList<EmployeeRole> employees;
    private static EmployeeContainer instance;
    
    private EmployeeContainer()
    {
        employees = new ArrayList<>();
    }

    public static EmployeeContainer getInstance()
    {
        if(instance == null)
        {
            instance = new EmployeeContainer();
        }
        return instance;
    }
    public void add(EmployeeRole employee)
    {
        employees.add(employee);
    }
    public void remove(EmployeeRole employee)
    {
        employees.remove(employee);
    }
    public ArrayList<EmployeeRole> read()
    {
        return employees;
    }
}
