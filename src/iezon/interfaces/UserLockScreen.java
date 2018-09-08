package iezon.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import iezon.main.Init;
import iezon.main.Window;
import iezon.users.User;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class UserLockScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> userButtons = new ArrayList<JButton>();

	public UserLockScreen() {
		setBounds(0, 0, 584, 462);
		setLayout(null);
		
		JLabel lblPleaseChooseA = new JLabel("Please choose a user...");
		lblPleaseChooseA.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblPleaseChooseA.setBounds(170, 51, 313, 43);
		add(lblPleaseChooseA);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 564, 131);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		for(User u : Init.usrController.getAllUsers()) {
			userButtons.add(new JButton(u.getFname()));
			userButtons.get(userButtons.size() -1).setFont(new Font("Tahoma", Font.BOLD, 16));
			userButtons.get(userButtons.size() - 1).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Init.usrController.setCurrentUser(u);
					LockScreen.setDisplayMessage();
					Window.guiController.setVisible("User Lock Screen", false);
					Window.guiController.setVisible("Lock Screen", true);
				}
			});
			panel.add(userButtons.get(userButtons.size() -1));
		}
	}
}
