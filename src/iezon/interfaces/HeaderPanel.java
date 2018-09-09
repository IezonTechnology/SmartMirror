package iezon.interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import iezon.main.Init;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class HeaderPanel extends JPanel {
	private JTextField textField;

	public HeaderPanel() {

		setBounds(0, 0, 584, 70);
		setLayout(null);
		setBackground(Color.BLACK);;
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(405, 48, 128, 20);
		add(textField);
		
		JLabel label = new JLabel("Search");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label.setBounds(360, 51, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Welcome back, " + Init.usrController.getCurrentUser().getFname());
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(10, 0, 285, 48);
		add(label_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(HeaderPanel.class.getResource("/iezon/images/search.png")));
		button.setForeground(Color.BLACK);
		button.setBackground(Color.BLACK);
		button.setBounds(534, 48, 50, 20);
		add(button);

		JLabel label_2 = new JLabel(new Date().toString());
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(10, 34, 241, 14);
		add(label_2);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(HeaderPanel.class.getResource("/iezon/images/streamline.png")));
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(518, 3, 30, 37);
		add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(HeaderPanel.class.getResource("/iezon/images/user.png")));
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(482, 3, 30, 37);
		add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(HeaderPanel.class.getResource("/iezon/images/lock.png")));
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(554, 3, 30, 37);
		add(button_3);

	}

}
