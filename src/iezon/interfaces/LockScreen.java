package iezon.interfaces;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import iezon.interfaces.options.InterfaceController;
import iezon.main.Init;
import iezon.main.Window;
import iezon.users.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LockScreen extends JPanel {
	
	private String code = "";

	private static final long serialVersionUID = 1L;

	public LockScreen() {
		setLayout(null);
		setBounds(0, 0, 584, 462);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				code += "1";
			}
		});
		button.setBounds(139, 202, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setBounds(241, 202, 89, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				code += "2";
			}
		});
		add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code += "3";
			}
		});
		button_2.setBounds(340, 202, 89, 23);
		add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBounds(139, 242, 89, 23);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code += "4";
			}
		});
		add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(241, 242, 89, 23);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code += "5";
			}
		});
		add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(340, 242, 89, 23);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code += "6";
			}
		});
		add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setBounds(139, 282, 89, 23);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code += "7";
			}
		});
		add(button_6);
		
		JButton button_7 = new JButton("0");
		button_7.setBounds(139, 322, 89, 23);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code += "0";
			}
		});
		add(button_7);
		
		JButton btnGo = new JButton("GO");
		btnGo.setBounds(340, 322, 89, 23);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Init.usrController.getCurrentUser().checkLogin(Integer.parseInt(code))) {
					Window.guiController.setVisible("Lock Screen", false);
					Window.guiController.setVisible("Home Screen", true);
				} else {
					InterfaceController.showMessage("Incorrect passcode combination.");
					code = "";
				}
		}});
		add(btnGo);
		
		JButton button_9 = new JButton("9");
		button_9.setBounds(340, 282, 89, 23);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code += "9";
			}
		});
		add(button_9);
		
		JButton button_10 = new JButton("8");
		button_10.setBounds(241, 282, 89, 23);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code += "8";
			}
		});
		add(button_10);
		
		User currentUser = Init.usrController.getCurrentUser();
		JLabel lblWelcomeBack = new JLabel("Welcome back, " + currentUser.getFname() + " " + currentUser.getLname());
		lblWelcomeBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeBack.setBounds(139, 100, 290, 52);
		add(lblWelcomeBack);
		
		JLabel lblStatusLocked = new JLabel("Status: Locked");
		lblStatusLocked.setBounds(139, 165, 89, 14);
		add(lblStatusLocked);

	}

}
