package Model;


public class Loan
{
    private String startOfLoan;
    private String endOfLoan;
    private double price;
    private CustomerRole customer;
    private EmployeeRole employee;
    private Tool tool;
    
    public Loan(String startOfLoan, String endOfLoan, double price, CustomerRole customer, EmployeeRole employee, Tool tool)
    {
        this.startOfLoan = startOfLoan;
        this.endOfLoan = endOfLoan;
        this.price = price;
        this.customer = customer;
        this.employee = employee;
        this.tool = tool;
    }
    
    public String getStartOfLoan()
    {
        return startOfLoan;
    }
    public String getEndOfLoan()
    {
        return endOfLoan;
    }
    public double getPrice()
    {
        return price;
    }
    public CustomerRole getCustomer()
    {
        return customer;
    }
    public EmployeeRole getEmployee()
    {
        return employee;
    }
    public Tool getTool()
    {
        return tool;
    }
    public void setEndOfLoan(String endOfLoan)
    {
        this.endOfLoan = endOfLoan;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setCustomer(CustomerRole customer)
    {
        this.customer = customer;
    }
    public void setEmployee(EmployeeRole employee)
    {
        this.employee = employee;
    }
}
