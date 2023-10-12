package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.*;
import model.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class OrderGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtVareNUmmer;
	private JTextField txtAntal;
	private JTextField txtVareHus;
	private OrderLineTableModel otm;
	private OrderController orderController;
	private Staff currentStaff;
	private JLabel lblUser;
	private SalesOrder currentOrder;
	private JTable tblOrder;
	private JTextField txtPhone;
	private Customer currentCUstomer;
	private JLabel lblNavn;
	private JLabel lblAdress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderGUI dialog = new OrderGUI(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderGUI(Staff CurrentStaff) {
		this.currentStaff = CurrentStaff;
		this.orderController = new OrderController();
		orderController.createOrder();
		setModal(true);
		setBounds(100, 100, 884, 557);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.EAST);
				{
					lblUser = new JLabel("user");
					panel_1.add(lblUser);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{79, 91, 296, 0, 57, 49, 19, 10, 49, 0};
			gbl_panel.rowHeights = new int[]{23, 20, 20, 23, 261, 23, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JLabel lblVareNummer = new JLabel("Vare Nummer : ");
			GridBagConstraints gbc_lblVareNummer = new GridBagConstraints();
			gbc_lblVareNummer.anchor = GridBagConstraints.WEST;
			gbc_lblVareNummer.insets = new Insets(0, 0, 5, 5);
			gbc_lblVareNummer.gridx = 0;
			gbc_lblVareNummer.gridy = 0;
			panel.add(lblVareNummer, gbc_lblVareNummer);
			
			txtVareNUmmer = new JTextField();
			GridBagConstraints gbc_txtVareNUmmer = new GridBagConstraints();
			gbc_txtVareNUmmer.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtVareNUmmer.insets = new Insets(0, 0, 5, 5);
			gbc_txtVareNUmmer.gridx = 1;
			gbc_txtVareNUmmer.gridy = 0;
			panel.add(txtVareNUmmer, gbc_txtVareNUmmer);
			txtVareNUmmer.setColumns(10);
			
			JLabel lblkunde = new JLabel("kunde Tlf:");
			GridBagConstraints gbc_lblkunde = new GridBagConstraints();
			gbc_lblkunde.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblkunde.insets = new Insets(0, 0, 5, 5);
			gbc_lblkunde.gridx = 3;
			gbc_lblkunde.gridy = 0;
			panel.add(lblkunde, gbc_lblkunde);
			
			txtPhone = new JTextField();
			GridBagConstraints gbc_txtPhone = new GridBagConstraints();
			gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
			gbc_txtPhone.gridwidth = 3;
			gbc_txtPhone.gridx = 4;
			gbc_txtPhone.gridy = 0;
			panel.add(txtPhone, gbc_txtPhone);
			txtPhone.setColumns(10);
			
			JButton btnSearch = new JButton("Søg");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Search();
				}
			});
			GridBagConstraints gbc_btnSearch = new GridBagConstraints();
			gbc_btnSearch.anchor = GridBagConstraints.NORTH;
			gbc_btnSearch.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
			gbc_btnSearch.gridwidth = 2;
			gbc_btnSearch.gridx = 7;
			gbc_btnSearch.gridy = 0;
			panel.add(btnSearch, gbc_btnSearch);
			
			JLabel lblAntal = new JLabel("Antal : ");
			GridBagConstraints gbc_lblAntal = new GridBagConstraints();
			gbc_lblAntal.anchor = GridBagConstraints.WEST;
			gbc_lblAntal.insets = new Insets(0, 0, 5, 5);
			gbc_lblAntal.gridx = 0;
			gbc_lblAntal.gridy = 1;
			panel.add(lblAntal, gbc_lblAntal);
			
			txtAntal = new JTextField();
			GridBagConstraints gbc_txtAntal = new GridBagConstraints();
			gbc_txtAntal.anchor = GridBagConstraints.NORTH;
			gbc_txtAntal.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAntal.insets = new Insets(0, 0, 5, 5);
			gbc_txtAntal.gridx = 1;
			gbc_txtAntal.gridy = 1;
			panel.add(txtAntal, gbc_txtAntal);
			txtAntal.setColumns(10);
			
			lblNavn = new JLabel("");
			GridBagConstraints gbc_lblNavn = new GridBagConstraints();
			gbc_lblNavn.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNavn.insets = new Insets(0, 0, 5, 5);
			gbc_lblNavn.gridx = 5;
			gbc_lblNavn.gridy = 1;
			panel.add(lblNavn, gbc_lblNavn);
			
			JLabel lblVarehus = new JLabel("VareHus : ");
			GridBagConstraints gbc_lblVarehus = new GridBagConstraints();
			gbc_lblVarehus.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblVarehus.insets = new Insets(0, 0, 5, 5);
			gbc_lblVarehus.gridx = 0;
			gbc_lblVarehus.gridy = 2;
			panel.add(lblVarehus, gbc_lblVarehus);
			
			txtVareHus = new JTextField();
			GridBagConstraints gbc_txtVareHus = new GridBagConstraints();
			gbc_txtVareHus.anchor = GridBagConstraints.NORTH;
			gbc_txtVareHus.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtVareHus.insets = new Insets(0, 0, 5, 5);
			gbc_txtVareHus.gridx = 1;
			gbc_txtVareHus.gridy = 2;
			panel.add(txtVareHus, gbc_txtVareHus);
			txtVareHus.setColumns(10);
			
			lblAdress = new JLabel("");
			GridBagConstraints gbc_lblAdress = new GridBagConstraints();
			gbc_lblAdress.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblAdress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAdress.gridx = 5;
			gbc_lblAdress.gridy = 2;
			panel.add(lblAdress, gbc_lblAdress);
			
			JButton btnTilføj = new JButton("Tilføj");
			GridBagConstraints gbc_btnTilføj = new GridBagConstraints();
			gbc_btnTilføj.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnTilføj.insets = new Insets(0, 0, 5, 5);
			gbc_btnTilføj.gridx = 1;
			gbc_btnTilføj.gridy = 3;
			panel.add(btnTilføj, gbc_btnTilføj);
			
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane.gridwidth = 9;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 4;
			panel.add(scrollPane, gbc_scrollPane);
			
			tblOrder = new JTable();
			scrollPane.setViewportView(tblOrder);
			
			JButton btnFjern = new JButton("Fjern Valgte Vare");
			GridBagConstraints gbc_btnFjern = new GridBagConstraints();
			gbc_btnFjern.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnFjern.insets = new Insets(0, 0, 0, 5);
			gbc_btnFjern.gridwidth = 2;
			gbc_btnFjern.gridx = 0;
			gbc_btnFjern.gridy = 5;
			panel.add(btnFjern, gbc_btnFjern);
			
			JLabel lbltotal = new JLabel("Total :");
			GridBagConstraints gbc_lbltotal = new GridBagConstraints();
			gbc_lbltotal.anchor = GridBagConstraints.NORTH;
			gbc_lbltotal.fill = GridBagConstraints.HORIZONTAL;
			gbc_lbltotal.insets = new Insets(0, 0, 0, 5);
			gbc_lbltotal.gridwidth = 2;
			gbc_lbltotal.gridx = 6;
			gbc_lbltotal.gridy = 5;
			panel.add(lbltotal, gbc_lbltotal);
			
			JLabel lblprice = new JLabel("price");
			GridBagConstraints gbc_lblprice = new GridBagConstraints();
			gbc_lblprice.anchor = GridBagConstraints.NORTH;
			gbc_lblprice.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblprice.gridx = 8;
			gbc_lblprice.gridy = 5;
			panel.add(lblprice, gbc_lblprice);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okClicked();
						
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
						exit();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			displayOrder();
			update();
		}
	}

	private void Search() {
		int phone = Integer.parseInt(txtPhone.getText());
		currentCUstomer = orderController.findCustomer(phone);
		lblNavn.setText(currentCUstomer.getFname() + " " + currentCUstomer.getLname());
		lblAdress.setText(currentCUstomer.getCustomerAddress()+ " " + currentCUstomer.getZipcode() + " " + currentCUstomer.getCity());
		
	}

	protected void exit() {
		this.dispose();
		this.setVisible(false);
		
	}

	private void update() {
		lblUser.setText(currentStaff.getFname() + " " + currentStaff.getLname());
		
	}

	public void okClicked() {
		this.dispose();
		this.setVisible(false);
	}
	
	private void displayOrder()
	{
		List<OrderLine> ols = orderController.getOrderLines();
		otm = new OrderLineTableModel(ols);
		this.tblOrder.setModel(otm);
		
	}
}
