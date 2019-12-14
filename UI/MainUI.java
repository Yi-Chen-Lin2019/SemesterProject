package UI;
/**
 * Description of MainMenu goes here.
 * 
 * @author knol, mhi, hnv
 * @version 2018.10.19
 * @version 2019.03.29 changed menu to danish and changed method names to reflect the other example
 * @version 2019.03.29 changed menu to English
 */
public class MainUI {
    // instance variables 
    private ProductUI productUI;
    private OrderUI orderUI;
    

    /**
     * Constructor for objects of MainMenu
     */
    public MainUI() {
        // initialise instance variables
        productUI = new ProductUI();
        orderUI = OrderUI.getInstance();
    }
    

    public void start() { 
        boolean exit=false;
        while (!exit) { //! means while exit not is true (that is: false)
            int choice = writeMainMenu();
            if(choice == 1) {
                productUI.start();    
            }
            else if(choice == 2) { 
                System.out.println("Feature not implemented yet");
            }
            else if(choice == 3) {
                orderUI.main(); 
            }
            else if(choice == 4) {
                System.out.println("Feature not implemented yet");
            }
            else {
                writeEnd();
                exit = true;
            }//end else
        }//end while
    }
    
    private int writeMainMenu(){
        TextOptions menu = new TextOptions("\n ***Main menu***", "Quit the program");
        menu.addOption("Product menu");
        menu.addOption("Customer Menu");
        menu.addOption("Order menu");
        menu.addOption("Loan menu");
        return menu.prompt();
    }
    
    private void writeEnd() {
        System.out.println(" Thank you and goodbye ");
        
    }
}
