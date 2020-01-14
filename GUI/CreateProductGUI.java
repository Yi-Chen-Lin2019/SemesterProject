package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import Control.*;
import Model.*;

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

public class CreateProductGUI extends JDialog {

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
	private JCheckBox chckbxItsUnique;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateProductGUI dialog = new CreateProductGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateProductGUI() {
		setModal(true);
		setTitle("Create Product");
		initialize();
		setBounds(100, 100, 450, 300);
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
			textFieldBarcode.setBounds(88, 12, 130, 26);
			contentPanel.add(textFieldBarcode);
			textFieldBarcode.setColumns(10);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(88, 45, 130, 26);
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblCategoryId = new JLabel("Category ID:");
			lblCategoryId.setBounds(230, 50, 100, 16);
			contentPanel.add(lblCategoryId);
		}
		{
			JLabel lblName = new JLabel("Name: ");
			lblName.setBounds(27, 50, 61, 16);
			contentPanel.add(lblName);
		}
		{
			JLabel lblMinimumAmount = new JLabel("Minimum amount:");
			lblMinimumAmount.setBounds(27, 83, 124, 16);
			contentPanel.add(lblMinimumAmount);
		}
		{
			JLabel lblMaximumAmount = new JLabel("Maximum amount:");
			lblMaximumAmount.setBounds(240, 83, 124, 16);
			contentPanel.add(lblMaximumAmount);
		}
		{
			JLabel lblRecommandPrice = new JLabel("Recommand price:");
			lblRecommandPrice.setBounds(27, 131, 124, 16);
			contentPanel.add(lblRecommandPrice);
		}
		{
			JLabel lblTradePrice = new JLabel("Trade price:");
			lblTradePrice.setBounds(27, 159, 124, 16);
			contentPanel.add(lblTradePrice);
		}
		{
			JLabel lblCost = new JLabel("Cost:");
			lblCost.setBounds(27, 187, 124, 16);
			contentPanel.add(lblCost);
		}
		{
			JLabel lblSellPrice = new JLabel("Sell price:");
			lblSellPrice.setBounds(27, 215, 124, 16);
			contentPanel.add(lblSellPrice);
		}
		{
			textFieldId = new JTextField();
			textFieldId.setBounds(319, 45, 55, 26);
			contentPanel.add(textFieldId);
			textFieldId.setColumns(10);
		}
		{
			textFieldMin = new JTextField();
			textFieldMin.setBounds(146, 78, 71, 26);
			contentPanel.add(textFieldMin);
			textFieldMin.setColumns(10);
		}
		{
			textFieldMax = new JTextField();
			textFieldMax.setColumns(10);
			textFieldMax.setBounds(362, 78, 71, 26);
			contentPanel.add(textFieldMax);
		}
		{
			textFieldRec = new JTextField();
			textFieldRec.setBounds(156, 126, 130, 26);
			contentPanel.add(textFieldRec);
			textFieldRec.setColumns(10);
		}
		{
			textFieldTrade = new JTextField();
			textFieldTrade.setBounds(108, 154, 130, 26);
			contentPanel.add(textFieldTrade);
			textFieldTrade.setColumns(10);
		}
		{
			textFieldCost = new JTextField();
			textFieldCost.setBounds(108, 182, 130, 26);
			contentPanel.add(textFieldCost);
			textFieldCost.setColumns(10);
		}
		{
			textFieldSell = new JTextField();
			textFieldSell.setBounds(108, 215, 130, 26);
			contentPanel.add(textFieldSell);
			textFieldSell.setColumns(10);
		}
		
		chckbxItsUnique = new JCheckBox("It's an unique item");
		chckbxItsUnique.setBounds(271, 198, 149, 23);
		contentPanel.add(chckbxItsUnique);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addProduct();
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
		iCtr = new ItemController();
	}
	
	private void addProduct() {
		boolean done = 
				iCtr.addProduct(
				textFieldBarcode.getText(), textFieldName.getText(), 
				Integer.parseInt(textFieldId.getText()), 
				Integer.parseInt(textFieldMin.getText()), Integer.parseInt(textFieldMax.getText()), 
				Double.parseDouble(textFieldRec.getText()), Double.parseDouble(textFieldTrade.getText()), 
				Double.parseDouble(textFieldCost.getText()), Double.parseDouble(textFieldSell.getText()));
		if(done) {
			if(chckbxItsUnique.getSelectedObjects() !=null) {
			Product p = (Product) iCtr.getItem(textFieldBarcode.getText());
			p.makeUnique();}
		}else{
			JOptionPane.showMessageDialog(this, "Product cannot be added, try again");
		};
		closeDialog();
	}
	private void closeDialog() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
	}
	
}
