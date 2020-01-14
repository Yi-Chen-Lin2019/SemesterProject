package Model;
import java.util.*;

public class EmployeeContainer
{
    private ArrayList<EmployeeRole> employees;
    
    public EmployeeContainer()
    {
        employees = new ArrayList<>();
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
