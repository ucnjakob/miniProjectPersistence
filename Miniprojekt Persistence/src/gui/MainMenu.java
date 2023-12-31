package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Staff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private Staff Currentstaff;
	private JLabel lblUser;
	private JButton btnAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param currentStaff 
	 */
	public MainMenu(Staff currentStaff) {
		this.Currentstaff = currentStaff;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 908, 876);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1, BorderLayout.NORTH);
		
		lblUser = new JLabel("user");
		panel_1.add(lblUser);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutClicked();
			}
		});
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblWesternStyle = new JLabel("Western Style ");
		lblWesternStyle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		panel_2.add(lblWesternStyle);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{612, 97, 0};
		gbl_panel_3.rowHeights = new int[]{23, 23, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnOrder = new JButton("Create Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderMenu();
			}
			
		});
		GridBagConstraints gbc_btnOrder = new GridBagConstraints();
		gbc_btnOrder.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnOrder.gridx = 1;
		gbc_btnOrder.gridy = 0;
		panel_3.add(btnOrder, gbc_btnOrder);
		
		btnAdmin = new JButton("admin button");
		GridBagConstraints gbc_btnAdmin = new GridBagConstraints();
		gbc_btnAdmin.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdmin.gridx = 1;
		gbc_btnAdmin.gridy = 1;
		panel_3.add(btnAdmin, gbc_btnAdmin);
		
		update();
		isAdmin();
	}
	

	private void isAdmin() {
		if (Currentstaff.isAdmin())
		{
			btnAdmin.setVisible(true);
			btnAdmin.setEnabled(true);
		}
		else
		{
			btnAdmin.setVisible(false);
			btnAdmin.setEnabled(false);
		}
		
	}

	private void update() {
		lblUser.setText(Currentstaff.getFname() + " " + Currentstaff.getLname());
		
	}

	public void LogoutClicked() {
		Login login = new Login();
		login.setVisible(true);
		this.dispose();
		this.setVisible(false);
		
	}

	public void OrderMenu() {
		OrderGUI order = new OrderGUI(Currentstaff);
		order.setVisible(true);
	}

}
