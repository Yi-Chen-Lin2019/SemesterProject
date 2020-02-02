package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.GenericOrder;
import Model.ItemDescriptor;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchResultGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private OrderHandller oHandller;
	private ItemHandller iHandller;
	private JScrollPane scrollPaneOrder;
	private JScrollPane scrollPaneItem;
	//private static SearchHandller searchHandller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchResultGUI dialog = new SearchResultGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchResultGUI() {
		setTitle("Serach Result");
		//this.searchHandller = searchHandller;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 239, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeDialog();
					}
				});
				cancelButton.setActionCommand("OK");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
		}
		
		scrollPaneOrder = new JScrollPane();		
		scrollPaneOrder.setBounds(19, 31, 414, 75);
		getContentPane().add(scrollPaneOrder);
		
		
				
		scrollPaneItem = new JScrollPane();
		scrollPaneItem.setBounds(19, 142, 414, 85);
		getContentPane().add(scrollPaneItem);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setBounds(19, 6, 61, 16);
		getContentPane().add(lblOrder);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(19, 118, 61, 16);
		getContentPane().add(lblItem);
	}
	
	public void showOrderResult(ArrayList<GenericOrder> orders) {
		oHandller = new OrderHandller();
		oHandller.showSearchResult(orders, scrollPaneOrder);
	}
	
	private void closeDialog() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
	}
	
	public void showItemResult(ArrayList<ItemDescriptor> items) {
		iHandller = new ItemHandller();
		iHandller.showSearchResult(items, scrollPaneItem);
	}

}
