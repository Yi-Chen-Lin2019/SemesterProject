package UI;

import Control.*;
import Model.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TryMe.
 *
 * @author  Yi-Chen Lin
 * @version 20191215
 */
public class TryMe
{
    private ItemController iCtr = new ItemController();
    private OrderController oCtr = new OrderController();

    /**
     * Default constructor for test class Test2
     */
    public TryMe()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        iCtr.addProduct("001", "timber1", 1, 100, 200, 500, 500, 500, 500);
        ((Product)iCtr.getItem("001")).makeUnique();
        iCtr.addProduct("002", "Fridge", 100, 10, 15, 900, 900, 900.5, 900.9);
        iCtr.addCopy("002", "001002003");
        iCtr.addCopy("002", "001002004");
        iCtr.addPackage("100", "Kitchen", 7000.6);
        iCtr.addPackage("200", "Bathroom", 9000.5);
        

        oCtr.createOrder("20191215",null, null);
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
