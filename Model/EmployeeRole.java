package Model;

public abstract class EmployeeRole
{
    private String cPRNumber;
    private double salary;
    private String department;
    
    public EmployeeRole(String cPRNumber, double salary, String department)
    {
        this.cPRNumber = cPRNumber;
        this.salary = salary;
        this.department = department;
    }
    
    public String getCPRNumber()
    {
        return cPRNumber;
    }
    public double getSalary()
    {
        return salary;
    }
    public String getDepartment()
    {
        return department;
    }
    public void setCPRNumber(String cPRNumber)
    {
        this.cPRNumber = cPRNumber;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    public void setDepartment(String department)
    {
        this.department =department;
    }
}
