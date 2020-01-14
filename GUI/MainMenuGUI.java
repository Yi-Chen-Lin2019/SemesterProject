package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.*;
import Model.*;



import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuGUI extends JFrame {

	private JPanel contentPane;
	private CreateOrderGUI oGUI = new CreateOrderGUI();
	private CreateProductGUI pGUI = new CreateProductGUI();
	private JList<GenericOrder> listGenericOrder;
	private JList<ItemDescriptor> listItemDescriptor;
	private DefaultListModel<GenericOrder> listRepresentation;
	private DefaultListModel<ItemDescriptor> listRepresentationItem;
	private OrderController oCtr;
	private ItemController iCtr;
	private JScrollPane scrollPaneProduct;
	private JScrollPane scrollPaneOrder;
	private JButton btnAddProduct;
	private JButton btnDeleteProduct;
	private JButton btnEditProduct;
	private JToolBar toolBarProduct = new JToolBar();
	private JToolBar toolBarOrder = new JToolBar();
	private JTabbedPane tabbedPane;
	private JPanel panelOrder;
	private JPanel panelProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuGUI frame = new MainMenuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenuGUI() {
		setTitle("System");
		initialize();
		JOptionPane.showMessageDialog(null, "Please select order or product menu first");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel menuPanel = new JPanel();
		contentPane.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 6, 440, 265);
		
		panelOrder = new JPanel();
		tabbedPane.addTab("Order", null, panelOrder, null);
		panelOrder.setLayout(null);
		
		toolBarOrder = new JToolBar();
		toolBarOrder.setBounds(6, 6, 89, 22);
		panelOrder.add(toolBarOrder);
		
		JButton btnAddOrder = new JButton("＋");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oGUI.setVisible(true);
				updateOrderList();
			}
		});
		toolBarOrder.add(btnAddOrder);
		
		JButton btnDeleteOrder = new JButton("-");
		toolBarOrder.add(btnDeleteOrder);
		
		JButton btnEditOrder = new JButton("Edit");
		btnEditOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editOrderClicked();
			}
		});
		toolBarOrder.add(btnEditOrder);
		
		scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(96, 6, 317, 190);
		panelOrder.add(scrollPaneOrder);
		menuPanel.add(tabbedPane);
		
		panelProduct = new JPanel();
		tabbedPane.addTab("Product", null, panelProduct, null);
		panelProduct.setLayout(null);
		
		scrollPaneProduct = new JScrollPane();
		scrollPaneProduct.setBounds(96, 6, 317, 190);
		panelProduct.add(scrollPaneProduct);
		scrollPaneProduct.setToolTipText("");
		
		
		
		btnAddProduct = new JButton("+");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pGUI.setVisible(true);
				updateItemList();
			}
		});
		toolBarProduct.add(btnAddProduct);
		
		
		btnDeleteProduct = new JButton("-");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		toolBarProduct.setBounds(6, 6, 89, 22);
		panelProduct.add(toolBarProduct);
		
		toolBarProduct.add(btnDeleteProduct);
		
		btnEditProduct = new JButton("Edit");
		
		toolBarProduct.add(btnEditProduct);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnCancelButton = new JButton("Cancel");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(348, Short.MAX_VALUE)
					.addComponent(btnCancelButton)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnCancelButton))
		);
		panel_2.setLayout(gl_panel_2);
		btnCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeDialog();
			}
		});
		
		listGenericOrder = new JList<>();
		scrollPaneOrder.setViewportView(listGenericOrder);
		initializeOrderList();
		updateOrderList();
		
		listItemDescriptor = new JList<>();
		scrollPaneProduct.setViewportView(listItemDescriptor);
		initializeItemList();
		updateItemList();
		
	}
	
	private void initialize() {
		oCtr = new OrderController();
		iCtr = new ItemController();
	}
	private void updateOrderList() {
		listRepresentation = new DefaultListModel<GenericOrder>();
		ArrayList<GenericOrder> modelList = oCtr.getAllOrders();
		for(GenericOrder element : modelList) {
			listRepresentation.addElement(element);
		}
		listGenericOrder.setModel(listRepresentation);
	}
	private void initializeOrderList() {
		GenericOrderCellRenderer cellRenderer = new GenericOrderCellRenderer();
		listGenericOrder.setCellRenderer(cellRenderer);
		updateOrderList();	
	}
	private void closeDialog() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
	}
	private void showOrderList() {
		listGenericOrder = new JList<GenericOrder>();
		scrollPaneOrder.setViewportView(listGenericOrder);
		initializeOrderList();
		updateOrderList();
	}
	private void editOrderClicked() {
		GenericOrder theList = listGenericOrder.getSelectedValue();		
		if (theList != null) {
			ShowGenericOrderListUI listDetailView = new ShowGenericOrderListUI(theList);
			listDetailView.setVisible(true);
		}
		else {
			//lets show an error message
			JOptionPane.showMessageDialog(this, "Please create or select an order");
		}
		
	}
	private void showProductList() {
		listItemDescriptor = new JList<ItemDescriptor>();
		scrollPaneProduct.setViewportView(listItemDescriptor);
		initializeItemList();
		updateItemList();
	}

	private void initializeItemList() {
		ItemCellRenderer cellRenderer = new ItemCellRenderer();
		listItemDescriptor.setCellRenderer(cellRenderer);
		updateItemList();
		
	}

	private void updateItemList() {
		listRepresentationItem = new DefaultListModel<ItemDescriptor>();
		ArrayList<ItemDescriptor> modelList = iCtr.getAllItems();
		for(ItemDescriptor element : modelList) {
			listRepresentationItem.addElement(element);
		}
		listItemDescriptor.setModel(listRepresentationItem);
		
	}
}
