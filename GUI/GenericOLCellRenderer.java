package GUI;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import Model.GenericOL;
import Model.ItemDescriptor;
import Model.OrderLine;
import Model.OrderLineOfCopy;
import Model.Product;

public class GenericOLCellRenderer implements ListCellRenderer<GenericOL>{
	private DefaultListCellRenderer dlcr;
	
	@Override
	public Component getListCellRendererComponent(JList<? extends GenericOL> list, GenericOL value, int index,
			boolean isSelected, boolean cellHasFocus) {
		dlcr = new DefaultListCellRenderer();
		String textToShow = orderLineDescription(value)+ 
				 "   Price: "+value.getPrice()+ 
				orderLineOfCopyDescription(value);
		return dlcr.getListCellRendererComponent(list, textToShow, index, isSelected,
												 cellHasFocus);
	} 
	
	private String orderLineDescription(GenericOL value) {
		String s = "";
		if(value instanceof OrderLine) {
			s+= "Name: "+((OrderLine) value).getItem().getName()+
				"   Quantity: "+((OrderLine) value).getQuantity();
		}
		return s;
	}
	private String orderLineOfCopyDescription(GenericOL value) {
		String s = "   Serial number: ";
		if(value instanceof OrderLineOfCopy) {
			s+=((OrderLineOfCopy) value).getCopy().getSerialNumber();
		}else {
			s = "";
		}
		return s;
	}

}