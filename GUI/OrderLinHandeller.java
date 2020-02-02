package GUI;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import Control.OrderController;
import Control.OrderLineController;
import Model.GenericOrder;
import Model.OrderLine;
import Model.OrderLineOfCopy;
import Model.GenericOL;

public class OrderLinHandeller {
	private GenericOrder order;
	private JList<OrderLine> listOrderLine = new JList<>();
	private JList<OrderLineOfCopy> listOrderLineOfCopy = new JList<>();
	private JList<GenericOL> listGenericOL = new JList<>();
	//TestCellRenderer
	private DefaultListModel<GenericOL> listRepresentationGenericOL;
	private DefaultListModel<OrderLine> listRepresentationOrderLine;
	private DefaultListModel<OrderLineOfCopy> listRepresentationOrderLineOfCopy;
	private OrderLineController olCtr = new OrderLineController();
	private OrderController oCtr = new OrderController();
	private JScrollPane scrollPane;
	//private JScrollPane scrollPaneCopy;
	
	public OrderLinHandeller(GenericOrder order, JScrollPane scrollPane) {
		this.order = order;	
		this.scrollPane = scrollPane;
		//this.scrollPaneCopy = scrollPaneCopy;
		initializeOrderLine();
		//initializeOrderLineOfCopy();
	}
	/*
	private void initializeOrderLineOfCopy() {
		// TODO Auto-generated method stub
		OrderLineOfCopyCellRenderer cellRenderer = new OrderLineOfCopyCellRenderer();
		listOrderLineOfCopy.setCellRenderer(cellRenderer);
		scrollPaneCopy.setViewportView(listOrderLineOfCopy);
		if(order != null) {			
			listRepresentationOrderLineOfCopy = new DefaultListModel<OrderLineOfCopy>();
			ArrayList<OrderLineOfCopy> modelList = oCtr.getOrderLinesOfCopy(order.getID());
			if(modelList.size() != 0) {
				for(OrderLineOfCopy element : modelList) {
					listRepresentationOrderLineOfCopy.addElement(element);}
				listOrderLineOfCopy.setModel(listRepresentationOrderLineOfCopy);}
			}
	}*/

	public void updateOrderLineOfCopy(int orderID) {
		if(oCtr.findOrder(orderID) != null) {			
			listRepresentationOrderLineOfCopy = new DefaultListModel<OrderLineOfCopy>();
			ArrayList<OrderLineOfCopy> modelList = oCtr.getOrderLinesOfCopy(order.getID());
			if(modelList.size() != 0) {
				for(OrderLineOfCopy element : modelList) {
					listRepresentationOrderLineOfCopy.addElement(element);}
				listOrderLineOfCopy.setModel(listRepresentationOrderLineOfCopy);}
			}
	}

	public void updateOrderLine(int orderID) {
		//GenericOrder theList = listGenericOrder.getSelectedValue();
		if(oCtr.findOrder(orderID) != null) {			
			listRepresentationOrderLine = new DefaultListModel<OrderLine>();
			ArrayList<OrderLine> modelList = oCtr.getOrderLines(order.getID());
			if(modelList.size() != 0) {
				for(OrderLine element : modelList) {
					listRepresentationOrderLine.addElement(element);}
				listOrderLine.setModel(listRepresentationOrderLine);}
			}
		
	}
	private void initializeOrderLine() {
		/*
		OrderLineCellRenderer cellRenderer = new OrderLineCellRenderer();
		listOrderLine.setCellRenderer(cellRenderer);
		scrollPane.setViewportView(listOrderLine);
		//updateOrderLine();
		if(order != null) {			
			listRepresentationOrderLine = new DefaultListModel<OrderLine>();
			ArrayList<OrderLine> modelList = oCtr.getOrderLines(order.getID());
			if(modelList.size() != 0) {
				for(OrderLine element : modelList) {
					listRepresentationOrderLine.addElement(element);}
				listOrderLine.setModel(listRepresentationOrderLine);}
			}*/
		
		GenericOLCellRenderer cellRenderer = new GenericOLCellRenderer();
		listGenericOL.setCellRenderer(cellRenderer);
		scrollPane.setViewportView(listGenericOL);
		//updateOrderLine();
		if(order != null) {			
			listRepresentationGenericOL = new DefaultListModel<GenericOL>();
			ArrayList<GenericOL> modelList = oCtr.getTest(order.getID());
			if(modelList.size() != 0) {
				for(GenericOL element : modelList) {
					listRepresentationGenericOL.addElement(element);}
				listGenericOL.setModel(listRepresentationGenericOL);}
	}

}
	}
