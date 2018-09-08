package iezon.interfaces;

import javax.swing.JPanel;

public class Interface {

	private int id;
	private String identity;
	private JPanel panel;

	public Interface(int uniqueId, String uniqueIdentity, JPanel uniqueJPanel) {
		id = uniqueId;
		identity = uniqueIdentity;
		panel = uniqueJPanel;
	}

	public int getId() {
		return id;
	}

	public String getIdentity() {
		return identity;
	}

	public JPanel getPanel() {
		return panel;
	}

}
