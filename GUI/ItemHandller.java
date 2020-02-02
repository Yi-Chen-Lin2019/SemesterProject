package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import Model.*;

public class ItemHandller {
	private JList<ItemDescriptor> listItemDescriptor = new JList<>();
	private DefaultListModel<ItemDescriptor> listRepresentationItem;
	private JScrollPane scrollPane;
	
	
	//combine initialize and update to one method
		public void showSearchResult(ArrayList<ItemDescriptor> items, JScrollPane scrollPane) {
			//initialize
			this.scrollPane = scrollPane;
			ItemCellRenderer cellRenderer = new ItemCellRenderer();
			listItemDescriptor.setCellRenderer(cellRenderer);
			scrollPane.setViewportView(listItemDescriptor);
			
			//update
			listRepresentationItem = new DefaultListModel<ItemDescriptor>();
			ArrayList<ItemDescriptor> modelList = items;
			if(modelList.size()!=0) {
				for(ItemDescriptor element : modelList) {
					listRepresentationItem.addElement(element);}
				listItemDescriptor.setModel(listRepresentationItem);
			}
			
			//click action
			listItemDescriptor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()>=2) {
						editItemClicked();
					}			
				}
			});
		}


	private void editItemClicked() {
		// TODO Auto-generated method stub
		
	}

}
