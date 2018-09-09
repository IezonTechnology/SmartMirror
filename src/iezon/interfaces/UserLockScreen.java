package iezon.interfaces;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import iezon.main.Init;
import iezon.main.Window;
import iezon.users.User;

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
		
		/*
		 * LIST GUI
		 */
		
		JList<String> list = new JList<String>();
		list.setBounds(10, 285, 313, 116);
		add(list);
		
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		for(User u : Init.usrController.getAllUsers()) {
			DLM.addElement(u.getFname());
		}
		list.setModel(DLM);
		
		list.setVisible(false); // Comment out to show
		
		/*
		 * END OF LIST GUI
		 */
		
		for(User u : Init.usrController.getAllUsers()) {
			userButtons.add(new JButton(u.getFname()));
			userButtons.get(userButtons.size() -1).setFont(new Font("Tahoma", Font.BOLD, 16));
			userButtons.get(userButtons.size() - 1).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Init.usrController.setCurrentUser(u);
					LockScreen.setDisplayMessage();
					Window.guiController.addPanel("Lock Screen", new LockScreen());
					Window.guiController.removePanel("User Lock Screen");
				}
			});
			panel.add(userButtons.get(userButtons.size() -1));
		}
	}
}
