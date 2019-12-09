package Model;
import java.util.*;

public class LoanContainer
{
    private ArrayList<Loan> loans;
    private static LoanContainer instance;
    
    private LoanContainer()
    {
        loans = new ArrayList<>();
    }

    public static LoanContainer getInstance()
    {
        if(instance == null)
        {
            instance = new LoanContainer();
        }
        return instance;
    }
    public void add(Loan loan)
    {
        loans.add(loan);
    }
    public void remove(Loan loan)
    {
        loans.remove(loan);
    }
    public ArrayList<Loan> read()
    {
        return loans;
    }
}