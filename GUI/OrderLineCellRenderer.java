package GUI;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import Model.OrderLine;

public class OrderLineCellRenderer implements ListCellRenderer<OrderLine>{
	private DefaultListCellRenderer dlcr;
	
	@Override
	public Component getListCellRendererComponent(JList<? extends OrderLine> list, OrderLine value, int index,
			boolean isSelected, boolean cellHasFocus) {
		dlcr = new DefaultListCellRenderer();
		String textToShow =  "Quantity: " + value.getQuantity() + "     Price: "+value.getPrice();
		return dlcr.getListCellRendererComponent(list, textToShow, index, isSelected,
												 cellHasFocus);
	} 

}
