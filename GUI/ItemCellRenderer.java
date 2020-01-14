package GUI;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import Model.*;

public class ItemCellRenderer implements ListCellRenderer<ItemDescriptor>{
	private DefaultListCellRenderer dlcr;
	
	public Component getListCellRendererComponent(JList<? extends ItemDescriptor> list, ItemDescriptor value, int index,
		boolean isSelected, boolean cellHasFocus) {
		dlcr = new DefaultListCellRenderer();
		String textToShow =  "Name: "+ value.getName()+ "     Barcode: "+ value.getBarcode();
		return dlcr.getListCellRendererComponent(list, textToShow, index, isSelected,
													 cellHasFocus);
	}

}
