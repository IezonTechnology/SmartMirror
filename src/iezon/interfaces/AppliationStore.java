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

public class AppliationStore extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(64, 224, 474, 238);
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnAppA = new JButton("APP A");
		btnAppA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppA);
			}
		});
		GridBagConstraints gbc_btnAppA = new GridBagConstraints();
		gbc_btnAppA.insets = new Insets(0, 0, 5, 5);
		gbc_btnAppA.gridx = 1;
		gbc_btnAppA.gridy = 1;
		panel_1.add(btnAppA, gbc_btnAppA);
		
		JButton btnAppB = new JButton("APP B");
		btnAppB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppB);
			}
		});
		GridBagConstraints gbc_btnAppB = new GridBagConstraints();
		gbc_btnAppB.insets = new Insets(0, 0, 5, 5);
		gbc_btnAppB.gridx = 6;
		gbc_btnAppB.gridy = 1;
		panel_1.add(btnAppB, gbc_btnAppB);
		
		JButton btnAppC = new JButton("APP C");
		btnAppC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppC);
			}
		});
		GridBagConstraints gbc_btnAppC = new GridBagConstraints();
		gbc_btnAppC.insets = new Insets(0, 0, 5, 0);
		gbc_btnAppC.gridx = 11;
		gbc_btnAppC.gridy = 1;
		panel_1.add(btnAppC, gbc_btnAppC);
		
		JButton btnAppD = new JButton("APP D");
		btnAppD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppD);
			}
		});
		GridBagConstraints gbc_btnAppD = new GridBagConstraints();
		gbc_btnAppD.insets = new Insets(0, 0, 5, 5);
		gbc_btnAppD.gridx = 1;
		gbc_btnAppD.gridy = 3;
		panel_1.add(btnAppD, gbc_btnAppD);
		
		JButton btnAppE = new JButton("APP E");
		btnAppE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppE);
			}
		});
		GridBagConstraints gbc_btnAppE = new GridBagConstraints();
		gbc_btnAppE.insets = new Insets(0, 0, 5, 5);
		gbc_btnAppE.gridx = 6;
		gbc_btnAppE.gridy = 3;
		panel_1.add(btnAppE, gbc_btnAppE);
		
		JButton btnAppF = new JButton("APP F");
		btnAppF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppF);
			}
		});
		GridBagConstraints gbc_btnAppF = new GridBagConstraints();
		gbc_btnAppF.insets = new Insets(0, 0, 5, 0);
		gbc_btnAppF.gridx = 11;
		gbc_btnAppF.gridy = 3;
		panel_1.add(btnAppF, gbc_btnAppF);
		
		JButton btnAppG = new JButton("APP G");
		btnAppG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppG);
			}
		});
		GridBagConstraints gbc_btnAppG = new GridBagConstraints();
		gbc_btnAppG.insets = new Insets(0, 0, 5, 5);
		gbc_btnAppG.gridx = 1;
		gbc_btnAppG.gridy = 5;
		panel_1.add(btnAppG, gbc_btnAppG);
		
		JButton btnAppH = new JButton("APP H");
		btnAppH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppH);
			}
		});
		GridBagConstraints gbc_btnAppH = new GridBagConstraints();
		gbc_btnAppH.insets = new Insets(0, 0, 5, 5);
		gbc_btnAppH.gridx = 6;
		gbc_btnAppH.gridy = 5;
		panel_1.add(btnAppH, gbc_btnAppH);
		
		JButton btnAppI = new JButton("APP I");
		btnAppI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppI);
			}
		});
		GridBagConstraints gbc_btnAppI = new GridBagConstraints();
		gbc_btnAppI.insets = new Insets(0, 0, 5, 0);
		gbc_btnAppI.gridx = 11;
		gbc_btnAppI.gridy = 5;
		panel_1.add(btnAppI, gbc_btnAppI);
		
		JButton btnAppJ = new JButton("APP J");
		btnAppJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppJ);
			}
		});
		GridBagConstraints gbc_btnAppJ = new GridBagConstraints();
		gbc_btnAppJ.insets = new Insets(0, 0, 0, 5);
		gbc_btnAppJ.gridx = 1;
		gbc_btnAppJ.gridy = 7;
		panel_1.add(btnAppJ, gbc_btnAppJ);
		
		JButton btnAppK = new JButton("APP K");
		btnAppK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppK);
			}
		});
		GridBagConstraints gbc_btnAppK = new GridBagConstraints();
		gbc_btnAppK.insets = new Insets(0, 0, 0, 5);
		gbc_btnAppK.gridx = 6;
		gbc_btnAppK.gridy = 7;
		panel_1.add(btnAppK, gbc_btnAppK);
		
		JButton btnAppL = new JButton("APP L");
		btnAppL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You Have Successfully installed " + btnAppL);
			}
		});
		GridBagConstraints gbc_btnAppL = new GridBagConstraints();
		gbc_btnAppL.gridx = 11;
		gbc_btnAppL.gridy = 7;
		panel_1.add(btnAppL, gbc_btnAppL);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(64, 110, 474, 102);
		panel.add(panel_2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField == null) {
					JOptionPane.showMessageDialog(null, "Search box empty, please enter the name of an applicaiton." );
				}
				//TODO:: else search for values
				
			}
		});
		btnSearch.setBounds(421, 52, 89, 23);
		panel.add(btnSearch);
		

	}
}
