package UI;

import java.util.ArrayList;
/**
 * Description of TextOptions goes here.
 * 
 * @author knol, mhi
 * @version 2018.10.19
 */
public class TextOptions {
    // instance variables 
    private ArrayList<String> options;
    private String title;
    private boolean cancellable;


    /**
     * Constructor for objects of TextOptions
     */
    public TextOptions(String title, String cancelText) {
        // initialise instance variables
        options = new ArrayList<>();
        this.title = title;
        if(cancelText != null) {
            cancellable = true;
        }
        addOption(cancelText);
    }
    
    public TextOptions(String title) {
        this(title, null);
    }
    //set and get methods
    public void addOption(String option) {
        options.add(option);
    }
    
    public int prompt() {
        System.out.println(title);
        int size = options.size();
        for (int i = 0; i < size; i++){
            String currentOption = options.get(i);
            if (currentOption != null) {
                System.out.println(" [" + i + "]\t" + currentOption);
            }
        }
        int choice = -1;
        int lowerBound = 0;
        if (!cancellable) {
            lowerBound = 1;
        }
        while (choice < lowerBound || choice >= size) {
           choice = TextInput.inputNumber("Input number"); 
        }
        return choice;
    }
    //other methods
    
    public String inputString(String question)
    {
        TextInput input;
        input = new TextInput();
        return input.inputString(question);
    }
    
    public int inputNumber(String question)
    {
        TextInput input;
        input = new TextInput();
        return input.inputNumber(question);
    }
    
    public double inputDouble(String question)
    {
        TextInput input;
        input = new TextInput();
        return input.inputNumber(question);
    }
}
