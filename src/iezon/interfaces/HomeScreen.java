package iezon.interfaces;

import javax.swing.JLabel;
import javax.swing.JPanel;

import iezon.main.Init;
import iezon.main.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;

public class HomeScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 584, 70);
		add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(405, 48, 128, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSearch.setForeground(new Color(255, 255, 255));
		lblSearch.setBounds(360, 51, 46, 14);
		panel_1.add(lblSearch);
		
		JLabel welcomeLbl = new JLabel("Welcome back, " + Init.usrController.getCurrentUser().getFname());
		welcomeLbl.setForeground(new Color(255, 255, 255));
		welcomeLbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		welcomeLbl.setBounds(10, 0, 285, 48);
		panel_1.add(welcomeLbl);
		
		JButton btnFind = new JButton("");
		btnFind.setForeground(new Color(0, 0, 0));
		btnFind.setBackground(new Color(0, 0, 0));
		btnFind.setIcon(new ImageIcon(HomeScreen.class.getResource("/iezon/images/if_icon-111-search_314478 (1).png")));
		btnFind.setBounds(534, 48, 50, 20);
		panel_1.add(btnFind);
		
		JLabel timeLbl = new JLabel(new Date().toString());
		timeLbl.setForeground(new Color(255, 255, 255));
		timeLbl.setBounds(10, 34, 241, 14);
		panel_1.add(timeLbl);
		
		JButton button = new JButton("");
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(255, 255, 255));
		button.setIcon(new ImageIcon(HomeScreen.class.getResource("/iezon/images/if_lock_115716 (1).png")));
		button.setBounds(518, 3, 30, 37);
		panel_1.add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/iezon/images/if_Streamline-75_185095.png")));
		btnNewButton.setBounds(482, 3, 30, 37);
		panel_1.add(btnNewButton);
		
		JButton button_1 = new JButton("");
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setIcon(new ImageIcon(HomeScreen.class.getResource("/iezon/images/if_30.User_290120.png")));
		button_1.setBounds(554, 3, 30, 37);
		panel_1.add(button_1);
		
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
