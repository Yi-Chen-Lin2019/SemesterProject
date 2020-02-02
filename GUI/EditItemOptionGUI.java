package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ItemController;
import Model.ItemDescriptor;
import Model.KB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditItemOptionGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	CreateItemGUI listDetailView = new CreateItemGUI();
	private ItemDescriptor item;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		try {
			EditItemOptionGUI dialog = new EditItemOptionGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 */

	/**
	 * Create the dialog.
	 */
	public EditItemOptionGUI(ItemDescriptor item) {
		this.item = item;
		setBounds(100, 100, 403, 222);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblChooseACommand = new JLabel("Choose a command:");
		lblChooseACommand.setBounds(22, 34, 227, 29);
		contentPanel.add(lblChooseACommand);
		{
			JButton okButton = new JButton("Add copy serial number");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String serialNumber = JOptionPane.showInputDialog("Serial number:");
					ItemController iCtr = new ItemController();
					iCtr.addCopy(item.getBarcode(), serialNumber);
					closeDialog();
				}
			});
			okButton.setBounds(22, 75, 253, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			if(item instanceof KB) {
				okButton.setEnabled(false);
			}
		}
		
		JButton btnEdit = new JButton("Edit item information");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeDialog();
				ItemController iCtr = new ItemController();
				if(iCtr.removeItem(item.getBarcode())) {//CreateItemGUI listDetailView = new CreateItemGUI();
					listDetailView.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Item does not exist");
				}
			}
		});
		btnEdit.setBounds(22, 109, 253, 29);
		contentPanel.add(btnEdit);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	
	private void closeDialog() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
	}
}
