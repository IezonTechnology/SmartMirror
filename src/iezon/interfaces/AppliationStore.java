package iezon.interfaces;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import iezon.appstore.App;
import iezon.appstore.AppStoreController;
import iezon.main.Init;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.ImageIcon;

public class AppliationStore extends JPanel {
	private static final long serialVersionUID = 1L;
	public static AppStoreController asc;

	public AppliationStore() {
		
		setBounds(0, 0, 584, 462);
		setLayout(null);
		
		JPanel panel_3 = new HeaderPanel();
		add(panel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 70, 584, 392);
		add(panel);
		panel.setLayout(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 42, 584, 2);
		panel.add(separator_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(66, 86, 472, 272);
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 13;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JLabel lblStore = new JLabel("Store");
		lblStore.setBounds(240, 11, 83, 33);
		panel.add(lblStore);
		lblStore.setForeground(Color.WHITE);
		lblStore.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		
		/** arraylist loops applications into the Jpanel **/
		
		int x = 1;
		int y = 1;
		int count = 0;
		
for (App a : asc.getAllApps()) {
			
			JPanel p = new JPanel();
			p.setBackground(Color.BLACK);
			p.setLayout(gbl_panel_1);
			
			JButton btn = new JButton(a.getName());
			if(a.isInstalled())
				btn.setIcon(new ImageIcon(HeaderPanel.class.getResource("/iezon/images/streamline.png")));
			btn.setBackground(new Color(0, 191, 255));
			btn.setForeground(Color.BLACK);
			
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(App ap : asc.getAllApps()) {
						if(btn.getText().equalsIgnoreCase(ap.getName())) {
							if(!ap.isInstalled()) {
								if(ap.install()) {
									btn.setIcon(new ImageIcon(HeaderPanel.class.getResource("/iezon/images/streamline.png")));
									return;
								}
							} else {
								if(ap.uninstall()) {
									btn.setIcon(null);
									btn.setText(ap.getName());
									return;
								}
							}
						}
					}
				}
			});
			
			GridBagConstraints gbc_p = new GridBagConstraints();
			gbc_p.gridx = 1;
			gbc_p.gridy = 1;
			
			p.add(btn, gbc_p);
			
			gbc_p.gridx = 1;
			gbc_p.gridy = 3;
			JLabel cost = new JLabel("£" + a.getCost());
			cost.setForeground(new Color(0, 191, 255));
			p.add(cost, gbc_p);
			
			gbc_p.gridx = 1;
			gbc_p.gridy = 5;
			JLabel details = new JLabel("Details here");
			details.setForeground(new Color(0, 191, 255));
			p.add(details, gbc_p);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = x;
			gbc.gridy = y;
			
			// System.out.println("X is " + x + ", Y is " + y);
			
			panel_1.add(p, gbc);
			
			x = x + 3;
			if(count++ >= 3) {
				count = 0;
				y = y + 1;
				x = 1;
			}
		}
		

	}
}
