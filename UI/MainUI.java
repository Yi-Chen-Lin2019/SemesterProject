package UI;


public class MainUI
{
    private OrderUI orderUI;
    public MainUI()
    {
        orderUI = OrderUI.getInstance();
    }
    
    public void testOrder()
    {
        orderUI.main();
    }
}
