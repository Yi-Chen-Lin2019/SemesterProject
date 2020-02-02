package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.OrderController;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class CreateOrderGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDate;
	private OrderController oCtr;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateOrderGUI dialog = new CreateOrderGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateOrderGUI() {
		setTitle("Create Order");
		setModal(true);
		initialize();
		setBounds(100, 100, 451, 262);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		lblNewLabel = new JLabel("Order date:");
		contentPanel.add(lblNewLabel);
		
		textFieldDate = new JTextField();
		contentPanel.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newOrderClick();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeDialog();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void initialize() {
		oCtr = new OrderController();
	}
	
	private void closeDialog() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
	}
	private void newOrderClick() {
		String orderDate = textFieldDate.getText();
		if(orderDate.isBlank()) {
			JOptionPane.showMessageDialog(null, "Wrong input. Order cannot be added");
		} else {			
			if(oCtr.createOrder(orderDate)) {				
				JOptionPane.showMessageDialog(null, "Order added");
			} else {
				JOptionPane.showMessageDialog(null, "Order cannot be added");
			}
		}
		closeDialog();
	}
}
