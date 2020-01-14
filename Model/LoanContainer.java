package Model;
import java.util.*;

public class LoanContainer
{
    private ArrayList<Loan> loans;
    
    public LoanContainer()
    {
        loans = new ArrayList<>();
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