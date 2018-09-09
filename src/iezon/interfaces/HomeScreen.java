package iezon.interfaces;

import javax.swing.JLabel;
import javax.swing.JPanel;

import iezon.main.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public HomeScreen() {
		setBounds(0, 0, 584, 462);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Home Screen");
		lblNewLabel.setBounds(218, 56, 89, 14);
		add(lblNewLabel);
		
		JButton btnAppStore = new JButton("App Store");
		btnAppStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.guiController.addPanel("Application Store", new AppliationStore());
				Window.guiController.removePanel("Home Screen");
			}
		});
		btnAppStore.setBounds(207, 127, 89, 23);
		add(btnAppStore);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(207, 284, 89, 23);
		add(btnSettings);
		
		JButton btnAdminPanel = new JButton("Admin Panel");
		btnAdminPanel.setBounds(196, 358, 111, 23);
		add(btnAdminPanel);
		
		JButton btnAppList = new JButton("App List");
		btnAppList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAppList.setBounds(207, 189, 89, 23);
		add(btnAppList);
	}
}
