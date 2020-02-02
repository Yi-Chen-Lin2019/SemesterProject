package GUI;

import java.awt.Component;
import javax.swing.ListCellRenderer;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import Model.*;

public class GenericOrderCellRenderer implements ListCellRenderer<GenericOrder>{
	private DefaultListCellRenderer dlcr;
	
	@Override
	public Component getListCellRendererComponent(JList<? extends GenericOrder> list, GenericOrder value, int index,
			boolean isSelected, boolean cellHasFocus) {
		dlcr = new DefaultListCellRenderer();
		String textToShow =  "Order ID: "+ value.getID() +
				"     Date: "+ value.getOrderedDate()+ 
				"     Total: "+value.getTotalPrice()+
				"     Status: "+value.getStatus();
		return dlcr.getListCellRendererComponent(list, textToShow, index, isSelected,
												 cellHasFocus);
	}
}
