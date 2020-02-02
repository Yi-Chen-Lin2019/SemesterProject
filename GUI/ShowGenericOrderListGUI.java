package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ItemController;
import Control.OrderController;
import Control.OrderLineController;
import Model.GenericOrder;
import Model.ItemDescriptor;
import Model.KB;
import Model.Product;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ShowGenericOrderListGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBarcode;
	private OrderLineController olCtr = new OrderLineController();
	private OrderLinHandeller olHandller;
	private JScrollPane scrollPane;
	//private int orderID;
	private JTextField txtTotal;
	private GenericOrder order;
	private JButton okButton;
	private JButton cancelButton;
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			ShowGenericOrderListGUI dialog = new ShowGenericOrderListGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ShowGenericOrderListGUI(GenericOrder order) {
		setTitle("Edit Order");
		this.order = order;
		//this.orderID = order.getID();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(20, 28, 61, 16);
		contentPanel.add(lblBarcode);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(20, 56, 172, 26);
		contentPanel.add(txtBarcode);
		txtBarcode.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processOption();
			}
		});
		btnAdd.setBounds(106, 92, 86, 29);
		contentPanel.add(btnAdd);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 28, 212, 196);
		contentPanel.add(scrollPane);
		

		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setBounds(20, 219, 61, 16);
		contentPanel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBackground(new Color(238, 238, 238));
		txtTotal.setBorder(null);
		txtTotal.setText("$ " + order.getTotalPrice());
		txtTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtTotal.setEnabled(false);
		txtTotal.setEditable(false);
		txtTotal.setBounds(68, 214, 130, 26);
		contentPanel.add(txtTotal);
		txtTotal.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(219, 236, 285, 34);
			contentPanel.add(buttonPane);
			{
				okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeDialog();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeDialog();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(55)
						.addComponent(cancelButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(okButton)
						.addGap(79))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(cancelButton)
							.addComponent(okButton)))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
		
		JButton btnUpdateStatus = new JButton("Update Status");
		btnUpdateStatus.setBounds(20, 161, 179, 29);
		contentPanel.add(btnUpdateStatus);
		
		olHandller = new OrderLinHandeller(order,scrollPane);
		
		JLabel lblUpdateOrderTo = new JLabel("Update order status:");
		lblUpdateOrderTo.setBounds(20, 133, 172, 16);
		contentPanel.add(lblUpdateOrderTo);
		updateTotal(order);
		olHandller.updateOrderLine(order.getID());
	}
	
	private void addOrderLine(String barcode) {
		//String option = (String) comboBoxItem.getSelectedItem();
		//if(option.equals("(default)")) {
		//String barcode = txtBarcode.getText();
		//ItemController iCtr = new ItemController();
		//if(iCtr.getItem(barcode)==null) {
			//JOptionPane.showMessageDialog(this, "Wrong barcode, try again");
		//} else {
			
				//if(((Product) iCtr.getItem(barcode)).isUnique()){
					int quantity = Integer.parseInt(JOptionPane.showInputDialog("Type quantity: "));				
					if(olCtr.addOrderLine(order.getID(), barcode, quantity)) {
						JOptionPane.showMessageDialog(null, "Order Line added");
						olHandller.updateOrderLine(order.getID());
					} else {
						JOptionPane.showMessageDialog(null, "Order Line cannot be added");
					}
				//}else{
					//addCopyOrderLine(barcode);
		       //}
			
		updateTotal(order);
		olHandller.updateOrderLine(order.getID());
	}
	
	private void closeDialog() {
		this.setVisible(true);
		this.dispose();
	}
	
	private void updateTotal(GenericOrder order) {
		txtTotal.setText("$ " + order.getTotalPrice());
	}
	private void processOption() {
		String barcode = txtBarcode.getText();
		ItemController iCtr = new ItemController();
		ItemDescriptor item = iCtr.getItem(barcode);
		if(item == null) {
			JOptionPane.showMessageDialog(this, "Wrong barcode, try again");
		} 
		if(item instanceof Product) {
			if(((Product) iCtr.getItem(barcode)).isUnique()) {
				addOrderLine(barcode);
			} else {
				addCopyOrderLine(barcode);
			}			
		} else {
			addPackage(barcode);
		}
		olHandller.updateOrderLine(order.getID());
	
	}

	private void addPackage(String barcode) {
		// TODO Auto-generated method stub
		int quantity = Integer.parseInt(JOptionPane.showInputDialog("Type quantity: "));				
		if(olCtr.addOrderLine(order.getID(), barcode, quantity)) {
			JOptionPane.showMessageDialog(null, "Order Line added");
			olHandller.updateOrderLine(order.getID());
		} else {
			JOptionPane.showMessageDialog(null, "Order Line cannot be added");
		}
		updateTotal(order);
		olHandller.updateOrderLine(order.getID());
	}

	private void addCopyOrderLine(String barcode) {		
		olCtr.addCopyOrderLine(order.getID(), barcode);
		updateTotal(order);
		olHandller.updateOrderLine(order.getID());
	}
}
