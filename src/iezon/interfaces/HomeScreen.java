package iezon.interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import iezon.appstore.App;
import iezon.interfaces.options.InterfaceController;
import iezon.main.Init;
import iezon.main.Window;
import iezon.users.User;

public class HomeScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public HomeScreen() {
		setBounds(0, 0, 584, 462);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 70, 149, 381);
		add(panel);
		panel.setLayout(null);

		JButton btnAppStore = new JButton("App Store");
		btnAppStore.setBounds(10, 33, 129, 54);
		panel.add(btnAppStore);

		JButton btnApps = new JButton("Apps");
		btnApps.setBounds(10, 103, 129, 54);
		panel.add(btnApps);

		JButton btnAccount = new JButton("Browser");
		btnAccount.setBounds(10, 169, 129, 54);
		panel.add(btnAccount);

		JButton btnSleepLock = new JButton("Games");
		btnSleepLock.setBounds(10, 240, 129, 54);
		panel.add(btnSleepLock);

		JButton btnSettings = new JButton("Storage");
		btnSettings.setBounds(10, 310, 129, 54);
		panel.add(btnSettings);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 206, 209));
		panel_8.setBounds(0, 0, 149, 10);
		panel.add(panel_8);
		btnAppStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.guiController.addPanel("Application Store", new AppliationStore());
				Window.guiController.removePanel("Home Screen");
			}
		});

		JPanel panel_1 = new HeaderPanel();
		add(panel_1);

		HeaderPanel.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = HeaderPanel.txtappsusers.getText();
				if (query.isEmpty() || !query.contains(":")) {
					InterfaceController.showMessage("Please insert a query with a type :users or :apps");
					return;
				}
				switch (query.split(":")[1]) {
				case "users":
					for (User u : Init.usrController.getAllUsers()) {
						if (u.getFname().equalsIgnoreCase(query.split(":")[0])) {
							InterfaceController.showDialog(new Object[] {u.getFname() + " " +
									u.getLname(), u.getDob() }, "You found this user!");
							return;
						}
						if (u.getLname().equalsIgnoreCase(query.split(":")[0])) {
							InterfaceController.showDialog(new Object[] {u.getFname() + " " +
									u.getLname(), u.getDob() }, "You found this user!");
							return;
						}
					}
					InterfaceController.showMessage("Sorry, " + query.split(":")[0] + " does not exists.");
					break;
				case "apps":
					for (App a : AppliationStore.asc.getAllApps()) {
						if (a.getName().equalsIgnoreCase(query.split(":")[0])) {
							InterfaceController.showDialog(new Object[] {a.getName() + " £" +
									a.getCost(), a.getDetails()}, "You found this app!");
							return;
						}
					}
					InterfaceController.showMessage("Sorry, " + query.split(":")[0] + " does not exists.");
					break;
				default:
					InterfaceController.showMessage("Please insert a query with a type :users or :apps");
					break;
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(149, 70, 435, 392);
		add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(27, 11, 178, 153);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(232, 11, 178, 153);
		panel_2.add(panel_3);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(27, 228, 178, 153);
		panel_2.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(232, 228, 178, 153);
		panel_2.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 0, 0));
		panel_7.setBounds(27, 189, 383, 10);
		panel_2.add(panel_7);
		panel_7.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(0, 206, 209));
		panel_9.setBounds(0, 452, 149, 10);
		add(panel_9);
	}
}
