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
    

    /**
     * Constructor for objects of MainMenu
     */
    public MainUI() {
        // initialise instance variables
        productUI = new ProductUI();
        
    }

    public void start() { 
        boolean exit=false;
        while (!exit) { //! means while exit not is true (that is: false)
            int choice = writeMainMenu();
            if(choice == 1) {
                productUI.start();    
            }
            else if(choice == 2) { 
                //dvdMenu.start();
            }
            else if(choice == 3) {
                //loanMenu.start(); 
            }
            else if(choice == 4) {
                // TODO generate test data, this must not be part of final version
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
        menu.addOption("??");
        menu.addOption("??");
        menu.addOption("Generate test data (WIP)");
        return menu.prompt();
    }
    
    private void writeEnd() {
        System.out.println(" Thank you and goodbye ");
        
    }
}
