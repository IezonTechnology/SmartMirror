package iezon.interfaces;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public HomeScreen() {
		setBounds(0, 0, 584, 462);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Home Screen");
		lblNewLabel.setBounds(10, 11, 111, 14);
		add(lblNewLabel);
	}

}
