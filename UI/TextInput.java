package UI;

import java.util.Scanner;
/**
 * Description of TextInput goes here.
 * 
 * @author Istvan Knoll, Mogens Holm Iversen
 * @version 0.0.1 initial draft version
 */
public class TextInput {
    // instansvariables 

    /**
     * Constructor for objects of TextInput
     */
    public TextInput() {
        // initialise instansvariables
    }
    

    //other methods
    public static int inputNumber(String question){   
        Scanner keyboard = new Scanner(System.in);
        int number = 0;
        printQuestion(question);
        while (!keyboard.hasNextInt()){
            System.out.println("Input must be a number - try again");
            keyboard.nextLine();
        }
        number = keyboard.nextInt();
        return number;
    }
    
    public static double inputDouble(String question){   
        Scanner keyboard = new Scanner(System.in);
        double number = 0;
        printQuestion(question);
        while (!keyboard.hasNextDouble()){
            System.out.println("Input must be a double - try again");
            keyboard.nextLine();
        }
        number = keyboard.nextDouble();
        return number;
    }
    
    public static String inputString(String question) {
        Scanner keyboard = new Scanner(System.in);
        printQuestion(question);
        return keyboard.nextLine();
    }
    
    private static void printQuestion(String question) {
        System.out.print(" " + question + ": ");
    }

}
