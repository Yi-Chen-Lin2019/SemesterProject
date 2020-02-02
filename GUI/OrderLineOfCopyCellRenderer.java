package GUI;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import Model.OrderLine;
import Model.OrderLineOfCopy;

public class OrderLineOfCopyCellRenderer implements ListCellRenderer<OrderLineOfCopy>{
	private DefaultListCellRenderer dlcr;
	
	@Override
	public Component getListCellRendererComponent(JList<? extends OrderLineOfCopy> list, OrderLineOfCopy value, int index,
			boolean isSelected, boolean cellHasFocus) {
		dlcr = new DefaultListCellRenderer();
		String textToShow =   "     Price: "+value.getPrice()+ "     No.: "+value.getOrderLineNum();
		return dlcr.getListCellRendererComponent(list, textToShow, index, isSelected,
												 cellHasFocus);
	} 

}
