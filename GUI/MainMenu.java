package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.*;
import Control.*;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private CreateOrderGUI oGUI;
	private JScrollPane scrollPane;
	private JList<GenericOrder> listGenericOrder;
	private JList<OrderLine> listOrderLine;
	private DefaultListModel<GenericOrder> listRepresentation;
	private DefaultListModel<OrderLine> listRepresentationOrderLine;
	private OrderController oCtr;
	private OrderLineController olCtr;
	private JScrollPane scrollPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		initialize();
		setTitle("System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Order menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPane.setVisible(true);
			}
		});
		btnNewButton.setForeground(UIManager.getColor("OptionPane.foreground"));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(12, 47, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnProductMenu = new JButton("Product menu");
		btnProductMenu.setBounds(12, 76, 117, 29);
		contentPane.add(btnProductMenu);
		
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(327, 47, 117, 20);
		contentPane.add(toolBar);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addOrder();
			}
		});
		toolBar.add(btnAdd);
		
		JButton btnNewButton_1 = new JButton("-");
		toolBar.add(btnNewButton_1);
		
		JButton btnEdit = new JButton("Edit");
		toolBar.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		initializeList();
		updateList();
		
		JLabel lblInformationInThe = new JLabel("Information in the system:");
		lblInformationInThe.setBounds(136, 52, 190, 16);
		contentPane.add(lblInformationInThe);
		
		JPanel panel = new JPanel();
		panel.setBounds(141, 76, 303, 196);
		contentPane.add(panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		listGenericOrder = new JList<GenericOrder>();
		scrollPane_1.setViewportView(listGenericOrder);
		
		scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		//OrderLine
		olCtr = new OrderLineController();
		listOrderLine = new JList<OrderLine>();
		scrollPane_2.setViewportView(listOrderLine);
		updateOrderLine();
		
	}
	
	//orderline
	private void updateOrderLine() {
		OrderLineCellRenderer cellRenderer = new OrderLineCellRenderer();
		listOrderLine.setCellRenderer(cellRenderer);
		listRepresentationOrderLine = new DefaultListModel<OrderLine>();
		ArrayList<OrderLine> modelList = oCtr.getOrderLines(0);
		for(OrderLine element : modelList) {
			listRepresentationOrderLine.addElement(element);
		}
		listOrderLine.setModel(listRepresentationOrderLine);
	}
	
	
	private void initialize() {
		oCtr = new OrderController();
	}
	private void addOrder() {
		oGUI = new CreateOrderGUI();
		oGUI.setVisible(true);
		updateList();
	}
	private void updateList() {
		listRepresentation = new DefaultListModel<GenericOrder>();
		ArrayList<GenericOrder> modelList = oCtr.getAllOrders();
		for(GenericOrder element : modelList) {
			listRepresentation.addElement(element);
		}
		listGenericOrder.setModel(listRepresentation);
	}
	private void initializeList() {
		GenericOrderCellRenderer cellRenderer = new GenericOrderCellRenderer();
		listGenericOrder.setCellRenderer(cellRenderer);
		updateList();	
	}
}
