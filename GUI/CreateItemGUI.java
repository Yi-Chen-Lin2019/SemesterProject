package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import Control.*;
import Model.*;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreateItemGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldBarcode;
	private JTextField textFieldName;
	private JTextField textFieldId;
	private JTextField textFieldMin;
	private JTextField textFieldMax;
	private JTextField textFieldRec;
	private JTextField textFieldTrade;
	private JTextField textFieldCost;
	private JTextField textFieldSell;
	private ItemController iCtr;
	private JCheckBox chckbxNotUnique;
	protected JPanel panelProduct;
	private JPanel panelPackage;
	private JLabel lblPrice;
	private JTextField textFieldPrice;
	private JComboBox comboBox;
	private JTextField textFieldSerialNumber;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			CreateItemGUI dialog = new CreateItemGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * Create the dialog.
	 */
	public CreateItemGUI() {
		setModal(true);
		setTitle("Create Item");
		initialize();
		setBounds(100, 100, 487, 404);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBarcode = new JLabel("Barcode:");
			lblBarcode.setBounds(27, 17, 61, 16);
			contentPanel.add(lblBarcode);
		}
		{
			textFieldBarcode = new JTextField();
			textFieldBarcode.setBounds(166, 12, 130, 26);
			contentPanel.add(textFieldBarcode);
			textFieldBarcode.setColumns(10);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(166, 42, 130, 26);
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblName = new JLabel("Name: ");
			lblName.setBounds(27, 47, 61, 16);
			contentPanel.add(lblName);
		}
		{
			JLabel lblChooseTheType = new JLabel("Choose an item type:");
			lblChooseTheType.setBounds(27, 75, 191, 16);
			contentPanel.add(lblChooseTheType);
		}
		panelProduct = new JPanel();
		panelProduct.setBounds(21, 103, 312, 243);
		contentPanel.add(panelProduct);
		panelProduct.setLayout(null);
		
		chckbxNotUnique = new JCheckBox("Contains serial number:");
		chckbxNotUnique.setBounds(0, 216, 187, 23);
		panelProduct.add(chckbxNotUnique);
		{
			JLabel lblTradePrice = new JLabel("Trade price:");
			lblTradePrice.setBounds(6, 127, 124, 16);
			panelProduct.add(lblTradePrice);
		}
		{
			JLabel lblCost = new JLabel("Cost price:");
			lblCost.setBounds(6, 160, 124, 16);
			panelProduct.add(lblCost);
		}
		{
			textFieldTrade = new JTextField();
			textFieldTrade.setBounds(150, 122, 130, 26);
			panelProduct.add(textFieldTrade);
			textFieldTrade.setColumns(10);
		}
		{
			textFieldCost = new JTextField();
			textFieldCost.setBounds(150, 155, 130, 26);
			panelProduct.add(textFieldCost);
			textFieldCost.setColumns(10);
		}
		{
			JLabel lblSellPrice = new JLabel("Sell price:");
			lblSellPrice.setBounds(6, 188, 124, 16);
			panelProduct.add(lblSellPrice);
		}
		{
			textFieldSell = new JTextField();
			textFieldSell.setBounds(150, 183, 130, 26);
			panelProduct.add(textFieldSell);
			textFieldSell.setColumns(10);
		}
		{
			JLabel lblRecommandPrice = new JLabel("Recommand price:");
			lblRecommandPrice.setBounds(6, 99, 124, 16);
			panelProduct.add(lblRecommandPrice);
		}
		{
			textFieldRec = new JTextField();
			textFieldRec.setBounds(150, 94, 130, 26);
			panelProduct.add(textFieldRec);
			textFieldRec.setColumns(10);
		}
		panelProduct.setVisible(false);
		panelProduct.setEnabled(false);
		{
			JLabel lblMinimumAmount = new JLabel("Minimum amount:");
			lblMinimumAmount.setBounds(6, 66, 124, 16);
			panelProduct.add(lblMinimumAmount);
		}
		{
			textFieldMin = new JTextField();
			textFieldMin.setBounds(150, 61, 71, 26);
			panelProduct.add(textFieldMin);
			textFieldMin.setColumns(10);
		}
		{
			JLabel lblMaximumAmount = new JLabel("Maximum amount:");
			lblMaximumAmount.setBounds(6, 38, 124, 16);
			panelProduct.add(lblMaximumAmount);
		}
		{
			textFieldMax = new JTextField();
			textFieldMax.setBounds(150, 33, 71, 26);
			panelProduct.add(textFieldMax);
			textFieldMax.setColumns(10);
		}
		{
			JLabel lblCategoryId = new JLabel("Category ID:");
			lblCategoryId.setBounds(6, 6, 100, 16);
			panelProduct.add(lblCategoryId);
		}
		{
			textFieldId = new JTextField();
			textFieldId.setBounds(150, 1, 55, 26);
			panelProduct.add(textFieldId);
			textFieldId.setColumns(10);
		}
		panelProduct.setVisible(false);
		panelProduct.setEnabled(false);
		
		textFieldSerialNumber = new JTextField();
		textFieldSerialNumber.setBounds(192, 215, 130, 26);
		panelProduct.add(textFieldSerialNumber);
		textFieldSerialNumber.setColumns(10);
		{
			panelPackage = new JPanel();
			panelPackage.setBounds(21, 103, 312, 243);
			contentPanel.add(panelPackage);
			panelPackage.setLayout(null);
			{
				lblPrice = new JLabel("Price:");
				lblPrice.setBounds(6, 6, 61, 16);
				panelPackage.add(lblPrice);
			}
			{
				textFieldPrice = new JTextField();
				textFieldPrice.setBounds(150, 1, 130, 26);
				panelPackage.add(textFieldPrice);
				textFieldPrice.setColumns(10);
			}
		}
		textFieldSerialNumber.setVisible(false);
		chckbxNotUnique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNotUnique.isSelected()) {
					textFieldSerialNumber.setVisible(true);
				} else {
					textFieldSerialNumber.setVisible(false);
				}
			}
		});
		panelPackage.setVisible(false);
		panelPackage.setEnabled(false);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDiffPanel();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"null", "Product", "Package"}));
		comboBox.setBounds(166, 71, 167, 27);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						if(comboBox.getSelectedItem().equals("Product")) {
							addProduct();
						}
						if(comboBox.getSelectedItem().equals("Package")) {
							addPackage();
						}
						if(comboBox.getSelectedItem().equals("null")) {
							JOptionPane.showMessageDialog(null, "Item type required");
						}
						}catch(NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "You must fill all the boxes with proper input");
						}
					}
				});
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
	}
	private void initialize() {
		iCtr = new ItemController();
	}
	
	private void addProduct() {
		
			if(iCtr.getItem(textFieldBarcode.getText())!=null) {
				JOptionPane.showMessageDialog(this, "Barcode duplication, try other input again");
			} else {
				boolean done = 
						iCtr.addProduct(
						textFieldBarcode.getText(), 
						textFieldName.getText(), 
						Integer.parseInt(textFieldId.getText()), 
						Integer.parseInt(textFieldMin.getText()), Integer.parseInt(textFieldMax.getText()), 
						Double.parseDouble(textFieldRec.getText()), Double.parseDouble(textFieldTrade.getText()), 
						Double.parseDouble(textFieldCost.getText()), Double.parseDouble(textFieldSell.getText()));
				
				if(done) {
					if(chckbxNotUnique.isSelected()) {
						//Product p = (Product) iCtr.getItem(textFieldBarcode.getText());
						//p.makeUnique();
						boolean copyAdded = 
								iCtr.addCopy(textFieldBarcode.getText(), textFieldSerialNumber.getText());
						if(!copyAdded) {
							JOptionPane.showMessageDialog(this, "Copy cannot be added, try again");
						} else {
							closeDialog();}
					} else {
						Product p = (Product) iCtr.getItem(textFieldBarcode.getText());
						p.makeUnique();
						closeDialog();
					}
					//closeDialog();
				} else {
						JOptionPane.showMessageDialog(this, "Product cannot be added, try again");				
				};
			}
		
		//closeDialog();
	}
	/* old
	private void addProduct() {
		boolean done = 
				iCtr.addProduct(
				textFieldBarcode.getText(), 
				textFieldName.getText(), 
				Integer.parseInt(textFieldId.getText()), 
				Integer.parseInt(textFieldMin.getText()), Integer.parseInt(textFieldMax.getText()), 
				Double.parseDouble(textFieldRec.getText()), Double.parseDouble(textFieldTrade.getText()), 
				Double.parseDouble(textFieldCost.getText()), Double.parseDouble(textFieldSell.getText()));
		if(done) {
			if(!chckbxNotUnique.isSelected()) {
				Product p = (Product) iCtr.getItem(textFieldBarcode.getText());
				p.makeUnique();
			} else {
				String serialNumber = 
				JOptionPane.showInputDialog("Type serial number:");
				boolean copyAdded = 
				iCtr.addCopy(textFieldBarcode.getText(), serialNumber);
					if(!copyAdded) {
						JOptionPane.showMessageDialog(this, "Copy cannot be added, try again");
					}
			}
			closeDialog();
		} else {
				JOptionPane.showMessageDialog(this, "Product cannot be added, try again");				
		};
		//closeDialog();
	}*/
	private void addPackage() {
		if(iCtr.getItem(textFieldBarcode.getText())!=null) {
			JOptionPane.showMessageDialog(this, "Barcode duplication, try other input again");
		} else {
			boolean done = 
					iCtr.addPackage(textFieldBarcode.getText(), 
					textFieldName.getText(), 
					Double.parseDouble(textFieldPrice.getText()));
			if(!done) {
				JOptionPane.showMessageDialog(this, "Package cannot be added, try again");
			} else {
				closeDialog();}
		}
	}
	private void closeDialog() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
	}
	private void showDiffPanel() {
		String option = (String) comboBox.getSelectedItem();
		switch(option) {
			case "null":{
				panelProduct.setVisible(false);
				panelProduct.setEnabled(false);
				panelPackage.setVisible(false);
				panelPackage.setEnabled(false);
				break;
			}
			case "Product":{
				panelPackage.setVisible(false);
				panelPackage.setEnabled(false);
				panelProduct.setVisible(true);
				panelProduct.setEnabled(true);
				break;
			}
			case "Package":{
				panelProduct.setVisible(false);
				panelProduct.setEnabled(false);
				panelPackage.setVisible(true);
				panelPackage.setEnabled(true);
				break;
			}
		}
	}
	private void editClicked() {
		
	}
}
