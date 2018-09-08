package iezon.interfaces;

import javax.swing.JLabel;
import javax.swing.JPanel;

import iezon.main.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadingScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public LoadingScreen() {
		setBounds(0, 0, 584, 462);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Loading...");
		lblNewLabel.setBounds(10, 11, 175, 14);
		add(lblNewLabel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.guiController.setVisible("Loading Screen", false);
				Window.guiController.setVisible("Home Screen", true);
			}
		});
		btnCancel.setBounds(80, 155, 89, 23);
		add(btnCancel);
	}
}
