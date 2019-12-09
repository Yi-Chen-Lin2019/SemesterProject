package Model;

public abstract class LegalPerson
{
    private String name;
    private String address;
    private String phoneNumber;
    private EmployeeRole employee;
    private CustomerRole customer;
    private SupplierRole supplier;
    
    public LegalPerson(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public EmployeeRole getEmployee()
    {
        return employee;
    }
    public CustomerRole getCustomer()
    {
        return customer;
    }
    public SupplierRole getSupplier()
    {
        return supplier;
    }
    public void addEmployee(EmployeeRole employee)
    {
        this.employee = employee;
    }
    public void addCustomer(CustomerRole customer)
    {
        this.customer = customer;
    }
    public void addSupplier(SupplierRole supplier)
    {
        this.supplier = supplier;
    }
}
