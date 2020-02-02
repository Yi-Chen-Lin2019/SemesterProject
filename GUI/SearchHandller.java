package GUI;

import Control.*;
import Model.*;

public class SearchHandller {
	private OrderController oCtr = new OrderController();
	//private OrderLineController olCtr = new OrderLineController();
	private ItemController iCtr = new ItemController();
	private int inputNum;
	private String input;
	
	//constructor
	public SearchHandller(String input) {
		this.input = input;
		
		
	}
	
	//method
	
	public GenericOrder searchOrderID() {
		try {
		inputNum = Integer.parseInt(input);
		GenericOrder order = null;
		if(oCtr.findOrder(inputNum) != null) {
			order = oCtr.findOrder(inputNum);}
		return order;
		} catch (NumberFormatException e) {
			return null;
		}
		
	}
	
	public GenericOrder searchOrderDate() {
		GenericOrder order = null;
		//need one more method in controller
		for(GenericOrder o : oCtr.getAllOrders()) {
			if(o.getOrderedDate().equals(input)) {
				order = o;
			}
		}
		return order;
	}
	
	public ItemDescriptor searchItemBarcode() {
		ItemDescriptor item = null;
		for(ItemDescriptor i : iCtr.getAllItems()) {
			if(i.getBarcode().equals(input)) {
				item = i;
			}
		}
		return item;
	}
	
	public ItemDescriptor searchItemName() {
		ItemDescriptor item = null;
		for(ItemDescriptor i : iCtr.getAllItems()) {
			if(i.getName().equals(input)) {
				item = i;
			}
		}
		return item;
	}
	
}
