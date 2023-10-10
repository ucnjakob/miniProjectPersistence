package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField pswPassword;
	private JTextField txtUsename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login");
		setBounds(100, 100, 299, 179);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel username = new JLabel("UserName");
			GridBagConstraints gbc_username = new GridBagConstraints();
			gbc_username.insets = new Insets(0, 0, 5, 5);
			gbc_username.gridx = 0;
			gbc_username.gridy = 1;
			contentPanel.add(username, gbc_username);
		}
		{
			txtUsename = new JTextField();
			GridBagConstraints gbc_txtUsename = new GridBagConstraints();
			gbc_txtUsename.insets = new Insets(0, 0, 5, 0);
			gbc_txtUsename.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUsename.gridx = 2;
			gbc_txtUsename.gridy = 1;
			contentPanel.add(txtUsename, gbc_txtUsename);
			txtUsename.setColumns(10);
		}
		{
			JLabel Password = new JLabel("Password");
			GridBagConstraints gbc_Password = new GridBagConstraints();
			gbc_Password.insets = new Insets(0, 0, 0, 5);
			gbc_Password.gridx = 0;
			gbc_Password.gridy = 3;
			contentPanel.add(Password, gbc_Password);
		}
		{
			pswPassword = new JPasswordField();
			GridBagConstraints gbc_pswPassword = new GridBagConstraints();
			gbc_pswPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_pswPassword.gridx = 2;
			gbc_pswPassword.gridy = 3;
			contentPanel.add(pswPassword, gbc_pswPassword);
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
