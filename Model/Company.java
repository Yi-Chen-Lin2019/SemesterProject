package Model;

public class Company extends LegalPerson
{
    private String cvrNumber;
    private String owner;
    private String contactinfo;

    public Company(String name,String address, String phoneNumber, String cvrNumber, String owner, String contactinfo)
    {
        super(name,address,phoneNumber);
        this.cvrNumber = cvrNumber;
        this.owner = owner;
        this.contactinfo = contactinfo;
    }

    public String getCVR()
    {
        return cvrNumber;
    }
    public String getOwner()
    {
        return owner;
    }
    public String getContactinfo()
    {
        return contactinfo;
    }
    public void setCVR(String cvrNumber)
    {
        this.cvrNumber = cvrNumber;
    }
    public void setOwner(String owner)
    {
        this.owner = owner;
    }
    public void setContactinfo(String contactinfo)
    {
        this.contactinfo = contactinfo;
    }
}

