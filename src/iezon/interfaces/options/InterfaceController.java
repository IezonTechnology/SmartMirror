package iezon.interfaces.options;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import iezon.main.Window;

public class InterfaceController {
	
	private ArrayList<Interface> panels = new ArrayList<Interface>();
	
	public InterfaceController() { }
	
	public void addPanel(String uniqueIdentity, JPanel uniqueJPanel) {
		panels.add(new Interface(getNextId(), uniqueIdentity, uniqueJPanel));
		Window.frame.getContentPane().add(panels.get(panels.size() -1).getPanel());
	}
	
	public void removePanel(String uniqueIdentity) {
		for(Interface i : panels) {
			if(i.getIdentity().equalsIgnoreCase(uniqueIdentity)) {
				this.setVisible(uniqueIdentity, false);
				Window.frame.getContentPane().remove(i.getId());
				updateIds();
				panels.remove(i);
			}
		}
	}
	
	private void updateIds() {
		for(Interface i : panels) {
			i.setId(i.getId() - 1);
		}
	}
	
	public void removePanel(int id) {
		for(Interface i : panels) {
			if(i.getId() == id) {
				this.setVisible(i.getIdentity(), false);
				Window.frame.getContentPane().remove(i.getId());
				updateIds();
				panels.remove(i);
			}
		}
	}
	
	public Interface getInterfaceById(int id) {
		for(Interface gui : panels) {
			if(gui.getId() == id)
				return gui;
		}
		return null;
	}
	
	public Interface getInterfaceByName(String name) {
		for(Interface gui : panels) {
			if(gui.getIdentity().equalsIgnoreCase(name))
				return gui;
		}
		return null;
	}
	
	public ArrayList<Interface> getAllInterfaces() {
		return panels;
	}
	
	private int getNextId() {
		return panels.size();
	}
	
	public void setVisible(String uniqueIdentity, boolean visibility) {
		int id = -1;
		
		for(Interface i : panels) {
			if(i.getIdentity().equalsIgnoreCase(uniqueIdentity)) {
				id = i.getId();
			}
		}
		
		if(id == -1) {
			return;
		}
		
		Window.frame.getContentPane().getComponent(id).setVisible(visibility);
		Window.frame.setTitle(uniqueIdentity);
	}
	
	public static void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Alert", JOptionPane.ERROR_MESSAGE);
	}

	public static Object showDialog(Object[] values, String msg) {
		return JOptionPane.showInputDialog(null,
			msg, "Input",
			JOptionPane.INFORMATION_MESSAGE, null,
			values, values[0]
		);
	}
	
}
