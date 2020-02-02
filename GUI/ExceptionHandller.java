package GUI;

import javax.swing.JOptionPane;

public class ExceptionHandller extends RuntimeException {
	private String key;
	//constructor
	public ExceptionHandller(String key) {
		this.key = key;
	}
	
	public void inputException() {
		JOptionPane.showMessageDialog(null, "Order cannot be added");
	}
	public String getKey()
    {
        return key;
    }
    
    /**
     * @return A diagnostic string containing the key in error.
     */
    public String toString()
    {	
    	JOptionPane.showMessageDialog(null, "Order cannot be added");
        return "Input exception: " + key + " was not valid.";
    }

}	
