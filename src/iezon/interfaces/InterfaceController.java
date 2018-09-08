package iezon.interfaces;

import java.util.ArrayList;

import javax.swing.JPanel;

import iezon.main.Window;

public class InterfaceController {
	
	private ArrayList<Interface> panels = new ArrayList<Interface>();
	
	public InterfaceController() { }
	
	public void addPanel(String uniqueIdentity, JPanel uniqueJPanel) {
		panels.add(new Interface(getNextId(), uniqueIdentity, uniqueJPanel));
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
	}

}
