package iezon.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import iezon.main.Init;
import iezon.main.Window;
import iezon.users.User;

public class UserLockScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> userButtons = new ArrayList<JButton>();

	public UserLockScreen() {
		setBounds(0, 0, 584, 462);
		
		for(User u : Init.usrController.getAllUsers()) {
			userButtons.add(new JButton(u.getFname()));
			userButtons.get(userButtons.size() - 1).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Init.usrController.setCurrentUser(u);
					LockScreen.setDisplayMessage();
					Window.guiController.setVisible("User Lock Screen", false);
					Window.guiController.setVisible("Lock Screen", true);
				}
			});
			add(userButtons.get(userButtons.size() -1));
		}
	}
}
