package iezon.interfaces;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import iezon.appstore.App;
import iezon.appstore.AppStoreController;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class AppliationStore extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private AppStoreController asc = new AppStoreController();

	public AppliationStore() {
		
		setBounds(0, 0, 584, 462);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 462);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(231, 53, 180, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchTheStore = new JLabel("Search the Store:");
		lblSearchTheStore.setBounds(112, 56, 92, 14);
		panel.add(lblSearchTheStore);
		
		JLabel lblStore = new JLabel("Store");
		lblStore.setBounds(269, 11, 50, 20);
		panel.add(lblStore);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 463, -15);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 36, 574, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-143, 97, 727, 2);
		panel.add(separator_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 224, 474, 214);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		/** arraylist loops applications into the Jpanel **/
		
		int x = 1;
		int y = 1;
		int count = 0;
		
for (App a : asc.getAllApps()) {
			
			JPanel p = new JPanel();
			p.setLayout(gbl_panel_1);
			
			JButton btn = new JButton(a.getName());
			
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btn.setText("Installed");
				}
			});
			
			GridBagConstraints gbc_p = new GridBagConstraints();
			gbc_p.gridx = 1;
			gbc_p.gridy = 1;
			
			p.add(btn, gbc_p);
			
			gbc_p.gridx = 1;
			gbc_p.gridy = 3;
			p.add(new JLabel("£" + a.getCost()), gbc_p);
			
			gbc_p.gridx = 1;
			gbc_p.gridy = 5;
			p.add(new JLabel("Details here"), gbc_p);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = x;
			gbc.gridy = y;
			
			// System.out.println("X is " + x + ", Y is " + y);
			
			panel_1.add(p, gbc);
			
			x = x + 2;
			if(count++ >= 3) {
				count = 0;
				y = y + 1;
				x = 1;
			}
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(64, 110, 474, 102);
		panel.add(panel_2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					panel_1.removeAll();
					
					int x = 1;
					int y = 1;
					int count = 0;
					for (App a : asc.getAllApps()) {
						
						JPanel p = new JPanel();
						p.setLayout(gbl_panel_1);
						
						JButton btn = new JButton(a.getName());
						
						btn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btn.setText("Installed");
							}
						});
						
						GridBagConstraints gbc_p = new GridBagConstraints();
						gbc_p.gridx = 1;
						gbc_p.gridy = 1;
						
						p.add(btn, gbc_p);
						
						gbc_p.gridx = 1;
						gbc_p.gridy = 3;
						p.add(new JLabel("£" + a.getCost()), gbc_p);
						
						gbc_p.gridx = 1;
						gbc_p.gridy = 5;
						p.add(new JLabel("Details here"), gbc_p);
						
						GridBagConstraints gbc = new GridBagConstraints();
						gbc.gridx = x;
						gbc.gridy = y;
						
						panel_1.add(p, gbc);
						
						x = x + 2;
						if(count++ >= 3) {
							count = 0;
							y = y + 1;
							x = 1;
						}
					}
				}
				//TODO:: else search for values
				for(App a : asc.getAllApps()) {
					if(a.getName().equalsIgnoreCase(textField.getText())) {
						
						panel_1.removeAll();
						
						GridBagConstraints gbc = new GridBagConstraints();
						gbc.gridx = 1;
						gbc.gridy = 1;
						
						JPanel p = new JPanel();
						p.setLayout(gbl_panel_1);
						
						JButton btn = new JButton(a.getName());
						
						btn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btn.setText("Installed");
							}
						});
						
						GridBagConstraints gbc_p = new GridBagConstraints();
						gbc_p.gridx = 1;
						gbc_p.gridy = 1;
						
						p.add(btn, gbc_p);
						
						gbc_p.gridx = 1;
						gbc_p.gridy = 3;
						p.add(new JLabel("£" + a.getCost()), gbc_p);
						
						gbc_p.gridx = 1;
						gbc_p.gridy = 5;
						p.add(new JLabel("Details here"), gbc_p);
						
						panel_1.add(p, gbc);
					}
				}
			}
		});
		btnSearch.setBounds(421, 52, 89, 23);
		panel.add(btnSearch);
		

	}
}
