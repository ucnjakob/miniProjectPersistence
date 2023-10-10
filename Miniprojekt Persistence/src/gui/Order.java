package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;

public class Order extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtVareNUmmer;
	private JTextField txtAntal;
	private JTextField txtVareHus;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Order dialog = new Order();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Order() {
		setBounds(100, 100, 729, 557);
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
					JLabel lblUser = new JLabel("user");
					panel_1.add(lblUser);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{79, 96, 412, 49, 49, 0};
			gbl_panel.rowHeights = new int[]{20, 20, 20, 23, 35, 267, 23, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_txtVareNUmmer.anchor = GridBagConstraints.NORTH;
			gbc_txtVareNUmmer.insets = new Insets(0, 0, 5, 5);
			gbc_txtVareNUmmer.gridx = 1;
			gbc_txtVareNUmmer.gridy = 0;
			panel.add(txtVareNUmmer, gbc_txtVareNUmmer);
			txtVareNUmmer.setColumns(10);
			
			JLabel lblAntal = new JLabel("Antal : ");
			GridBagConstraints gbc_lblAntal = new GridBagConstraints();
			gbc_lblAntal.anchor = GridBagConstraints.WEST;
			gbc_lblAntal.insets = new Insets(0, 0, 5, 5);
			gbc_lblAntal.gridx = 0;
			gbc_lblAntal.gridy = 1;
			panel.add(lblAntal, gbc_lblAntal);
			
			txtAntal = new JTextField();
			GridBagConstraints gbc_txtAntal = new GridBagConstraints();
			gbc_txtAntal.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAntal.anchor = GridBagConstraints.NORTH;
			gbc_txtAntal.insets = new Insets(0, 0, 5, 5);
			gbc_txtAntal.gridx = 1;
			gbc_txtAntal.gridy = 1;
			panel.add(txtAntal, gbc_txtAntal);
			txtAntal.setColumns(10);
			
			JLabel lblVarehus = new JLabel("VareHus : ");
			GridBagConstraints gbc_lblVarehus = new GridBagConstraints();
			gbc_lblVarehus.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblVarehus.insets = new Insets(0, 0, 5, 5);
			gbc_lblVarehus.gridx = 0;
			gbc_lblVarehus.gridy = 2;
			panel.add(lblVarehus, gbc_lblVarehus);
			
			txtVareHus = new JTextField();
			GridBagConstraints gbc_txtVareHus = new GridBagConstraints();
			gbc_txtVareHus.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtVareHus.anchor = GridBagConstraints.NORTH;
			gbc_txtVareHus.insets = new Insets(0, 0, 5, 5);
			gbc_txtVareHus.gridx = 1;
			gbc_txtVareHus.gridy = 2;
			panel.add(txtVareHus, gbc_txtVareHus);
			txtVareHus.setColumns(10);
			
			JButton btnTilføj = new JButton("Tilføj");
			GridBagConstraints gbc_btnTilføj = new GridBagConstraints();
			gbc_btnTilføj.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnTilføj.insets = new Insets(0, 0, 5, 5);
			gbc_btnTilføj.gridx = 1;
			gbc_btnTilføj.gridy = 3;
			panel.add(btnTilføj, gbc_btnTilføj);
			
			table = new JTable();
			GridBagConstraints gbc_table = new GridBagConstraints();
			gbc_table.fill = GridBagConstraints.BOTH;
			gbc_table.insets = new Insets(0, 0, 5, 0);
			gbc_table.gridwidth = 5;
			gbc_table.gridx = 0;
			gbc_table.gridy = 5;
			panel.add(table, gbc_table);
			
			JButton btnFjern = new JButton("Fjern Valgte Vare");
			GridBagConstraints gbc_btnFjern = new GridBagConstraints();
			gbc_btnFjern.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnFjern.insets = new Insets(0, 0, 0, 5);
			gbc_btnFjern.gridwidth = 2;
			gbc_btnFjern.gridx = 0;
			gbc_btnFjern.gridy = 6;
			panel.add(btnFjern, gbc_btnFjern);
			
			JLabel lbltotal = new JLabel("Total :");
			GridBagConstraints gbc_lbltotal = new GridBagConstraints();
			gbc_lbltotal.anchor = GridBagConstraints.NORTH;
			gbc_lbltotal.fill = GridBagConstraints.HORIZONTAL;
			gbc_lbltotal.insets = new Insets(0, 0, 0, 5);
			gbc_lbltotal.gridx = 3;
			gbc_lbltotal.gridy = 6;
			panel.add(lbltotal, gbc_lbltotal);
			
			JLabel lblprice = new JLabel("price");
			GridBagConstraints gbc_lblprice = new GridBagConstraints();
			gbc_lblprice.anchor = GridBagConstraints.NORTH;
			gbc_lblprice.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblprice.gridx = 4;
			gbc_lblprice.gridy = 6;
			panel.add(lblprice, gbc_lblprice);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
