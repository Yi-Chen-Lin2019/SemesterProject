package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Control.OrderController;
import Model.GenericOrder;
import Model.ItemDescriptor;

public class OrderHandller {
	private JList<GenericOrder> listGenericOrder = new JList<>();	
	private DefaultListModel<GenericOrder> listRepresentation;
	private OrderController oCtr = new OrderController();
	private JScrollPane scrollPane;
	
	
	public OrderHandller(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
		initializeOrderList(scrollPane);
	}
	
	public OrderHandller() {
		
	}
	
	public void updateOrderList() {
		listRepresentation = new DefaultListModel<GenericOrder>();
		ArrayList<GenericOrder> modelList = oCtr.getAllOrders();
		if(modelList.size()!=0) {
			for(GenericOrder element : modelList) {
				listRepresentation.addElement(element);
			}
			listGenericOrder.setModel(listRepresentation);
		}
		listGenericOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>=2) {
					editOrderClicked();
				}
			}
		});
	}
	public void initializeOrderList(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
		GenericOrderCellRenderer cellRenderer = new GenericOrderCellRenderer();
		listGenericOrder.setCellRenderer(cellRenderer);
		scrollPane.setViewportView(listGenericOrder);
		updateOrderList();		
	}
	

	//combine initialize and update to one method
	public void showSearchResult(ArrayList<GenericOrder> orders, JScrollPane scrollPane) {
		//initialize
		this.scrollPane = scrollPane;
		GenericOrderCellRenderer cellRenderer = new GenericOrderCellRenderer();
		listGenericOrder.setCellRenderer(cellRenderer);
		scrollPane.setViewportView(listGenericOrder);
		
		//update
		listRepresentation = new DefaultListModel<GenericOrder>();
		ArrayList<GenericOrder> modelList = orders;
		if(modelList.size()!=0) {
			for(GenericOrder element : modelList) {
				listRepresentation.addElement(element);}
			listGenericOrder.setModel(listRepresentation);
		}
		
		//click action
		listGenericOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>=2) {
					editOrderClicked();
				}			
			}
		});
	}
	
	
	public void editOrderClicked() {
		GenericOrder theList = listGenericOrder.getSelectedValue();		
		if (theList != null) {
			//olHandller = new OrderLinHandeller(theList,scrollPane_2);
			ShowGenericOrderListUI listDetailView = new ShowGenericOrderListUI(theList);
			listDetailView.setVisible(true);
			OrderLinHandeller olHandller = new OrderLinHandeller(theList, scrollPane);
			olHandller.updateOrderLine(theList.getID());
		}
		else {
			//lets show an error message
			JOptionPane.showMessageDialog(null, "Please create or select an order");
		}
	}
	
	
	
}
