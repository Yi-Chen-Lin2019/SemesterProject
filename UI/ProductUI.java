package UI;
import Control.*;

public class ProductUI
{
    private ItemController ItemCtr;
    private static ProductUI instance;
    /**
     * Constructor for objects of class DVDMenu
     */
    private ProductUI()
    {
        ItemCtr = ItemController.getInstance();
    }

    public static ProductUI getInstance()
    {
        if(instance == null)
        {
            instance = new ProductUI();   
        }
        return instance;
    }
    public void start() {
        boolean exit=false;
        while (!exit) {
            int choice = writeProductUI();
            if(choice == 1) {
                addProduct();  
                System.out.println("In add product");
            }
            else if(choice == 2) { 
                addPackage();
                System.out.println("In add package");
            }
            else if(choice == 3) {
                addCopy();
                System.out.println("In add copy");
            }
            else if(choice == 4) {
                removeProduct();
                System.out.println("In remove product");
            }
            else if(choice == 5) {
                removePackage();
                System.out.println("In remove package");
            }
            else if(choice == 6) {
                removeCopy();
                System.out.println("In remove copy");          
            }
            else if(choice == 7) {
                //manageProduct();
                System.out.println("In manage product");          
            }
            else if(choice == 8) {
                //managePackage();
                System.out.println("In manage package");          
            }
            else if(choice == 9) {
                //manageCopy();
                System.out.println("In manage copy");          
            }
            else if(choice == 10) {
                showAll();
                System.out.println("In print all");          
            }
            else {
                
                exit = true;
            }//end else
        }//end while
    }
    
    private int writeProductUI()
    {
        TextOptions menu = new TextOptions("\n ***Product menu***", "Go back to the Main Menu");
        menu.addOption("Add Product");
        menu.addOption("Add Package");
        menu.addOption("Add Copy");
        menu.addOption("Remove Product");
        menu.addOption("Remove Package");
        menu.addOption("Remove Copy");
        menu.addOption("Manage Product");
        menu.addOption("Manage Package");
        menu.addOption("Manage Copy");
        menu.addOption("Print All Items");
        return menu.prompt();
    }
    
    private void addProduct()
    {
        TextOptions text;
        text = new TextOptions("", "");
        System.out.println("Please fill out the next fields:");
        String barcode;
        barcode = text.inputString("Barcode");
        String name;
        name = text.inputString("Name");
        int id;
        id = text.inputNumber("Product id");
        int min;
        min = text.inputNumber("Mininum stock");
        int max;
        max = text.inputNumber("Maximum stock");
        double rec;
        rec = text.inputNumber("Recommended retail price");
        double trade;
        trade = text.inputNumber("Trade allowance");
        double cost;
        cost = text.inputNumber("Cost price");
        double sell;
        sell = text.inputNumber("Selling price");
        ItemCtr.addProduct(barcode, name, id, min, max, rec, trade, cost, sell);
        System.out.println("Product has been added.");
    }
    
    private void addPackage()
    {
        TextOptions text;
        text = new TextOptions("", "");
        System.out.println("Please fill out the next fields:");
        String barcode;
        barcode = text.inputString("Barcode");
        String name;
        name = text.inputString("Name");
        double price;
        price = text.inputNumber("Package price");
        ItemCtr.addPackage(barcode, name, price);
        System.out.println("Package has been added.");
    }
    
    private void addCopy()
    {
        TextOptions text;
        text = new TextOptions("", "");
        System.out.println("Please fill out the next fields:");
        String barcode;
        barcode = text.inputString("Barcode of product");
        String serialNumber;
        serialNumber = text.inputString("Serial number");
        ItemCtr.addCopy(barcode, serialNumber);
        System.out.println("Copy has been added.");
    }
    /*
    private void manageProduct()
    {
        TextOptions text;
        text = new TextOptions("", "");
        String barcode;
        barcode = text.inputString("Enter the name barcode of the Product");
        ItemCtr.manageProduct(barcode);
    }
    
    private void managePackage()
    {
        TextOptions text;
        text = new TextOptions("", "");
        String barcode;
        barcode = text.inputString("Enter the name barcode of the Package");
        ItemCtr.managePackage(barcode);
    }
    
    private void manageCopy()
    {
        TextOptions text;
        text = new TextOptions("", "");
        String serialNumber;
        serialNumber = text.inputString("Enter the serial number of Copy");
        ItemCtr.manageCopy(serialNumber);
    }*/
    
    private void removeProduct()
    {
        TextOptions text;
        text = new TextOptions("", "");
        boolean message;
        String barcode;
        barcode = text.inputString("Enter the barcode of product");
        message = ItemCtr.removeItem(barcode);
        System.out.println(message);
    }
    
    private void removePackage()
    {
        TextOptions text;
        text = new TextOptions("", "");
        boolean message;
        String barcode;
        barcode = text.inputString("Enter the barcode of package");
        message = ItemCtr.removeItem(barcode);
        System.out.println(message);
    }
    
    private void removeCopy()
    {
        TextOptions text;
        text = new TextOptions("", "");
        boolean message;
        String barcode;
        barcode = text.inputString("Enter the barcode of copy");
        message = ItemCtr.removeItem(barcode);
        System.out.println(message);
    }
    
    private void showAll()
    {
        ItemCtr.printAllItems();
    }
    
}
