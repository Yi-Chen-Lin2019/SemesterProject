package Control;
import Model.*;
import java.util.*;


public class ItemController
{
    private ItemContainer iCon;
    private static ItemController instance;
    private ItemController() {
        iCon = ItemContainer.getInstance();
    }
    
    public static ItemController getInstance()
    {
        if(instance == null)
        {
            instance = new ItemController();   
        }
        return instance;
    }
    public Copy getCopy(String barcode) {
        Copy c = null;
        if(getProduct(barcode)!= null) {
            c = getProduct(barcode).getCopy();
        }   
        return c;
    }
    private Product getProduct(String barcode)
    {
        Product p = null;
        if(getItem(barcode) !=null) {
            if(getItem(barcode) instanceof Product) {
                p = (Product) getItem(barcode);
            }else {
                System.out.println("This is not instance of product");
            }
        }else {
            System.out.println("There is no such item");
        }
        return p;
    }
    public boolean addCopy(String barcode, String serialNumber)
    {
        if(getItem(barcode) !=null)
        {
            Copy copy = new Copy(serialNumber);
            ((Product) getItem(barcode)).addCopy(copy);
            return true;
        }else {
            System.out.println("Try other barcode");
            return false;
        }
        
    }
    public ItemDescriptor getItem(String barcode) {
        ItemDescriptor item = null;
        for(int index = 0; index < iCon.read().size(); index++) {
            if(iCon.read().get(index).getBarcode().equals(barcode)) {
                item = iCon.read().get(index);
            }           
        }       
        return item;
    }
    public boolean addProduct(String barcode, String name, int id, int min, int max, double rec, double trade, double cost, double sell)
    {
        Product p = new Product(barcode, name, id, min, max, rec, trade, cost, sell);
        iCon.add(p);
        return true;
        
    }
    public boolean addPackage(String barcode, String name, double price)
    {
        KB pac = new KB(barcode, name, price);
        iCon.add(pac);  
        return true;
    } 
    
    public void printAllItems()
    {
        /*for(int index = 0; index < iCon.read().size(); index++) {               
                /*if(iCon.read().get(index) instanceof Product) {
                    p = (Product)iCon.read().get(index);
                    p.print();
            iCon.read().get(index).print();
            System.out.println("___________________");
        }*/      
        
        iCon.print();
    }
    
    public boolean removeItem(String barcode)
    {
        boolean finished = false;
            Iterator<ItemDescriptor> it = iCon.read().iterator();
            while(it.hasNext()){
                ItemDescriptor i = it.next();
                if(i.getBarcode().equals(barcode)){
                    it.remove();
                    finished = true;
                }else{
                    System.out.println("There's no such order ID");
                    finished = false;
                }
            }
        return finished;
    }
    

}
