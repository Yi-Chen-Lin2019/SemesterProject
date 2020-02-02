package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ItemController;
import Control.OrderController;
import Control.OrderLineController;
import Model.*;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowGenericOrderListUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private OrderLineController olCtr = new OrderLineController();
	private int orderID;
	private JLabel lblProduct;
	private OrderLinHandeller olHandller;
	private JScrollPane scrollPane;
	private JButton btnConfirm;
	
	

	/**
	 * Create the frame.
	 */
	public ShowGenericOrderListUI(GenericOrder order) {
		this.orderID = order.getID();		
		setTitle("Register Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 24, 243, 214);
		contentPane.add(scrollPane);
		olHandller = new OrderLinHandeller(order, scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 24, 157, 214);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddProduct = new JLabel("Package");
		lblAddProduct.setBounds(6, 109, 93, 16);
		panel.add(lblAddProduct);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"(default)", "Kitchen", "Bathroom"}));
		comboBox.setBounds(16, 137, 133, 27);
		panel.add(comboBox);
		
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addOrderLine();
			}
		});
		btnAddProduct.setBounds(34, 68, 117, 29);
		panel.add(btnAddProduct);
		
		lblProduct = new JLabel("Barcode");
		lblProduct.setBounds(6, 10, 61, 16);
		panel.add(lblProduct);
		
		textField = new JTextField();
		textField.setBounds(6, 38, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeDialog();
			}
		});
		btnCancel.setBounds(6, 243, 117, 29);
		contentPane.add(btnCancel);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Do you want to save changes? ");
				switch(option) {
					case 0:
					closeDialog();
					break;
					case 1:
					closeDialog();
					break;
					case 2:
					//updateOrderLineList();
					closeDialog();
					break;
					default:
					JOptionPane.showMessageDialog(null, "No legal choice");
				}
			}
		});
		btnConfirm.setBounds(327, 243, 117, 29);
		contentPane.add(btnConfirm);
		closeDialog();
	}
	private void addOrderLine() {
		String barcode = textField.getText();
		ItemController iCtr = new ItemController();
		if(iCtr.getItem(barcode)==null) {
			JOptionPane.showMessageDialog(this, "Wrong barcode, try again");
		}else{
			if(((Product) iCtr.getItem(barcode)).isUnique()){
				int quantity = Integer.parseInt(JOptionPane.showInputDialog("Type quantity: "));				
				if(olCtr.addOrderLine(orderID, barcode, quantity)) {
					JOptionPane.showMessageDialog(null, "Order Line added");
					olHandller.updateOrderLine(orderID);
				} else {
					JOptionPane.showMessageDialog(null, "Order Line cannot be added");
				}
			}else{
				olCtr.addCopyOrderLine(orderID, barcode);
			}
		}
	}
	private void closeDialog() {
		this.setVisible(false);
		this.dispose();
		
	}
}
