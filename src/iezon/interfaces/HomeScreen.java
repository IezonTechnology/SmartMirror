package iezon.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(27, 11, 178, 153);
		panel_2.add(scrollPane);

		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setBackground(new Color(0, 0, 0));
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{59, 53, 1, 0};
		gbl_panel_4.rowHeights = new int[]{15, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		// list.setBounds(173, 149, -169, -115);
		
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		for(App app : AppliationStore.asc.getAllApps()) {
			if(app.isInstalled())
				DLM.addElement(app.getName());
		}
		if(DLM.getSize() == 0)
			DLM.addElement("No apps installed");
		// panel_4.setLayout(null);
		
		JLabel lblMyApps = new JLabel("My Apps");
		lblMyApps.setBounds(59, 5, 53, 15);
		lblMyApps.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMyApps.setForeground(new Color(255, 255, 255));
		//lblMyApps.setBounds(58, 0, 91, 28);
		GridBagConstraints gbc_lblMyApps = new GridBagConstraints();
		gbc_lblMyApps.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMyApps.insets = new Insets(0, 0, 5, 5);
		gbc_lblMyApps.gridx = 0;
		gbc_lblMyApps.gridy = 0;
		panel_4.add(lblMyApps, gbc_lblMyApps);
		
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
		      @SuppressWarnings("deprecation")
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
		    	  if (!listSelectionEvent.getValueIsAdjusting()) {
		    		  JList<?> list = (JList<?>) listSelectionEvent.getSource();
		    		  for(Object value : list.getSelectedValues()) {
		    			  if(value.toString().equalsIgnoreCase("No apps installed"))
		    				 continue;
		    			  for(App allApps : AppliationStore.asc.getAllApps()) {
		    				  if(allApps.getName().equalsIgnoreCase(value.toString())) {
		    					  allApps.launch();
		    				  }
		    			  }
		    		  }
		    	  }
		      }
		};
		
		JList<String> list = new JList<String>();
		list.setBounds(91, 45, 0, 0);
		list.setBackground(new Color(0, 0, 0));
		list.setForeground(new Color(255, 255, 255));
		list.addListSelectionListener(listSelectionListener);
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.anchor = GridBagConstraints.WEST;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		panel_4.add(list, gbc_list);
		list.setModel(DLM);

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
