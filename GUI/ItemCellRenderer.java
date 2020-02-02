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
		String textToShow =  "Barcode: "+ value.getBarcode()+
				"     Name: "+ value.getName()+
				"     Price: " + value.getSellingPrice()+
				CopyDescription(value);
		/*
		if(value instanceof Product) {
			textToShow += 
			"     Min. amount: "+((Product) value).getMinStock() +
			"     Max. amount: "+((Product) value).getMaxStock() +
			"     Category ID: "+((Product) value).getCategoryID();
			if(!((Product) value).isUnique()) {
				textToShow +=
				"     Copies amount: "+((Product) value).getCopiesNum()+
				"     Serial number: " + ((Product) value).getCopies();
			}
		}*/
		
		return dlcr.getListCellRendererComponent(list, textToShow, index, isSelected,
													 cellHasFocus);
	}
	private String CopyDescription(ItemDescriptor value) {
		String s = "   Serial number: ";
		if(value instanceof Product && !((Product) value).isUnique()) {
			s+=((Product) value).getCopies();
		}else {
			s = "";
		}
		return s;
	}

}
