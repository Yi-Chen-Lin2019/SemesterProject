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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSplitPane;

public class MainMenuGUI extends JFrame {

	private JPanel contentPane;
	private CreateItemGUI iGUI = new CreateItemGUI();
	private JList<GenericOrder> listGenericOrder;
	private JList<ItemDescriptor> listItemDescriptor;
	private DefaultListModel<GenericOrder> listRepresentation;
	private DefaultListModel<ItemDescriptor> listRepresentationItem;
	private OrderController oCtr;
	private ItemController iCtr;
	private JScrollPane scrollPaneItem;
	private JScrollPane scrollPaneOrder;
	private JButton btnAddItem;
	private JButton btnDeleteItem;
	private JButton btnEditItem;
	private JToolBar toolBarItem = new JToolBar();
	private JToolBar toolBarOrder = new JToolBar();
	private JTabbedPane tabbedPane;
	private JPanel panelOrder;
	private JPanel panelItem;
	private JScrollPane scrollPaneOrderLine;
	private OrderLinHandeller olHandller;
	private JTextField txtSearch;
	private JButton btnGo;
	
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
		//JOptionPane.showMessageDialog(null, "Please select order or product menu first");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setBounds(0, 32, 588, 315);
		
		panelOrder = new JPanel();
		panelOrder.setBorder(null);
		tabbedPane.addTab("Order", null, panelOrder, null);
		panelOrder.setLayout(null);
		
		
		toolBarOrder = new JToolBar();
		toolBarOrder.setBounds(6, 6, 89, 22);
		panelOrder.add(toolBarOrder);
		
		JButton btnAddOrder = new JButton("+");
		btnAddOrder.setToolTipText("Add order");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				if(oCtr.createOrder(date.format(formatter).toString())) {				
					JOptionPane.showMessageDialog(null, "Order added");
				} else {
					JOptionPane.showMessageDialog(null, "Order cannot be added");
				}
				updateOrderList();
			}
		});
		toolBarOrder.add(btnAddOrder);
		
		JButton btnDeleteOrder = new JButton("-");
		btnDeleteOrder.setToolTipText("Delete order");
		toolBarOrder.add(btnDeleteOrder);
		
		JButton btnEditOrder = new JButton("Edit");
		btnEditOrder.setToolTipText("Edit order");
		
		toolBarOrder.add(btnEditOrder);
		
		scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setToolTipText("Double clicked or clicked edit button to edit");
		scrollPaneOrder.setBounds(6, 30, 346, 234);
		panelOrder.add(scrollPaneOrder);
		menuPanel.add(tabbedPane);
		
		scrollPaneOrderLine = new JScrollPane();
		scrollPaneOrderLine.setToolTipText("Show copy order lines");
		scrollPaneOrderLine.setEnabled(false);
		scrollPaneOrderLine.setBounds(357, 30, 204, 234);
		panelOrder.add(scrollPaneOrderLine);
		
		panelItem = new JPanel();
		tabbedPane.addTab("Item", null, panelItem, null);
		panelItem.setLayout(null);
		
		scrollPaneItem = new JScrollPane();
		scrollPaneItem.setBounds(16, 40, 539, 214);
		panelItem.add(scrollPaneItem);
		scrollPaneItem.setToolTipText("");
		
		
		
		btnAddItem = new JButton("+");
		btnAddItem.setToolTipText("Add item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iGUI = new CreateItemGUI();
				iGUI.setVisible(true);
				updateItemList();
			}
		});
		toolBarItem.add(btnAddItem);
		
		
		btnDeleteItem = new JButton("-");
		btnDeleteItem.setToolTipText("Delete item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//iCtr.removeItem(barcode);
			}
		});
		toolBarItem.setBounds(16, 6, 89, 22);
		panelItem.add(toolBarItem);
		
		toolBarItem.add(btnDeleteItem);
		
		btnEditItem = new JButton("Edit");
		btnEditItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//editItemClicked();
			}
		});
		btnEditItem.setToolTipText("Edit item");
		
		toolBarItem.add(btnEditItem);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnCancelButton = new JButton("Cancel");
		btnCancelButton.setToolTipText("Close the system");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(496, Short.MAX_VALUE)
					.addComponent(btnCancelButton)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addComponent(btnCancelButton)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		btnCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeDialog();
			}
		});
		
		
		
		
		listGenericOrder = new JList<>();
		listGenericOrder.setToolTipText("Double clicked or clicked edit bottom to edit");
		scrollPaneOrder.setViewportView(listGenericOrder);
		
		
		
		listItemDescriptor = new JList<>();
		listItemDescriptor.setToolTipText("Show all items");
		scrollPaneItem.setViewportView(listItemDescriptor);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Type in anything and search");
		txtSearch.setBounds(381, 9, 167, 21);
		menuPanel.add(txtSearch);
		txtSearch.setForeground(Color.BLACK);
		txtSearch.setColumns(10);
		
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(328, 9, 41, 16);
		menuPanel.add(lblSearch);
		
		btnGo = new JButton("Go");
		searchFunction();
		btnGo.setBackground(Color.WHITE);
		btnGo.setBounds(546, 7, 36, 23);
		menuPanel.add(btnGo);
		
		initializeItemList();
		updateItemList();
		listItemDescriptor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>=2) {
					editItemClicked();
				}
			}
		});
		
		initializeOrderList();
		updateOrderList();
		listGenericOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>=2) {
					editOrderClicked();
				}
			}
		});
		
		btnEditOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editOrderClicked();
			}
		});
	}
	
	private void initialize() {
		oCtr = new OrderController();
		iCtr = new ItemController();
		
	}
	private void closeDialog() {
		this.setVisible(false);
		this.dispose();
	}
	private void editOrderClicked() {
		GenericOrder theList = listGenericOrder.getSelectedValue();		
		if (theList != null) {
			olHandller = new OrderLinHandeller(theList,scrollPaneOrderLine);
			ShowGenericOrderListGUI listDetailView = new ShowGenericOrderListGUI(theList);
			listDetailView.setVisible(true);
			//olHandller.updateOrderLine(theList);
			//olHandller.updateOrderLineOfCopy(theList);
			olHandller.updateGenericOL(theList);
		}
		else {
			//lets show an error message
			JOptionPane.showMessageDialog(this, "Please create or select an order");
		}
		
	}
	private void editItemClicked() {
		ItemDescriptor theList = listItemDescriptor.getSelectedValue();
		if (theList != null) {
			EditItemOptionGUI listDetailView = new EditItemOptionGUI(theList);
			listDetailView.setVisible(true);
		}
		else {
			//lets show an error message
			JOptionPane.showMessageDialog(this, "Please create or select an item");
		}
	}
	
	private void updateOrderList() {
		listRepresentation = new DefaultListModel<GenericOrder>();
		ArrayList<GenericOrder> modelList = oCtr.getAllOrders();
		if(modelList.size()!=0) {
			for(GenericOrder element : modelList) {
				listRepresentation.addElement(element);
			}
			listGenericOrder.setModel(listRepresentation);
		}
		listGenericOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				GenericOrder theList = listGenericOrder.getSelectedValue();
				if(theList != null) {
					olHandller = new OrderLinHandeller(theList,scrollPaneOrderLine);
					//olHandller.updateOrderLine(theList);
					//olHandller.updateOrderLineOfCopy(theList);
					olHandller.updateGenericOL(theList);
				}			
			}
		});
		
	}
	private void initializeOrderList() {
		GenericOrderCellRenderer cellRenderer = new GenericOrderCellRenderer();
		listGenericOrder.setCellRenderer(cellRenderer);
		//scrollPane.setViewportView(listGenericOrder);
		updateOrderList();		
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
	
	private void searchFunction() {
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSearch.getText() != null && !txtSearch.getText().equals("")) {
					SearchHandller search = new SearchHandller(txtSearch.getText());
					//search if anything match
					ArrayList<GenericOrder> orders = new ArrayList<>();
					ArrayList<ItemDescriptor> items = new ArrayList<>();
					if(search.searchOrderDate() != null) {
						orders.add(search.searchOrderDate());
					}
					if(search.searchOrderID() != null){
						orders.add(search.searchOrderID());
					}
					if(search.searchItemBarcode() != null) {
						items.add(search.searchItemBarcode());
					}
					if(search.searchItemName() != null) {
						items.add(search.searchItemName());
					}
					//show the search result
					SearchResultGUI searchGUI = new SearchResultGUI();
					if(items.size() == 0 && orders.size() == 0) {
						JOptionPane.showMessageDialog(null,"No matching result");
					} else {
						if(orders.size()!= 0) {
							searchGUI.showOrderResult(orders);											
						}
						if(items.size() != 0) {
							searchGUI.showItemResult(items);
						}
						searchGUI.setVisible(true);
					}
			} else {
				JOptionPane.showMessageDialog(null,"Please type valid keyword");
			}
		}
		});
	}
}
