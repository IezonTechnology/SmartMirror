package iezon.appstore;
import javax.swing.JPanel;

import iezon.interfaces.HeaderPanel;
import iezon.interfaces.options.Interface;
import iezon.interfaces.options.InterfaceController;
import iezon.main.Window;

public class App {
	
	public String Name;
	public String Details;
	public double Cost;
	public boolean Installed = false;
	private JPanel panel;
	

	public App(String Name, String Details, double Cost, JPanel panel) {
		this.Name = Name;
		this.Cost = Cost;
		this.panel = panel;
	}
	
	public boolean isInstalled () {
		// TODO: Confirm directory is installed
		return Installed;
	}
	
	/*public void launch() {
		// InterfaceController.showMessage("Launching " + Name + " is soon to come!");
		try {
			Object inst = app.newInstance();
			Method[] allMethods = app.getDeclaredMethods();
			for (Method m : allMethods) {
				String mname = m.getName();
				if (!mname.startsWith("run")
				    || (m.getGenericReturnType() != JPanel.class)) {
				    continue;
				}
		 		Type[] pType = m.getGenericParameterTypes();
		 		if ((pType.length != 1)
				    || Locale.class.isAssignableFrom(pType[0].getClass())) {
		 		    continue;
		 		}
		 		try {
				    m.setAccessible(true);
				    Object o = m.invoke(inst, new Locale("", "", ""));
				    JPanel p = (JPanel) o ;
				    Window.guiController.addPanel("App", p);
				    for(Interface i : Window.guiController.getAllInterfaces()) {
						Window.guiController.removePanel(i.getIdentity());
					}
		 		} catch (InvocationTargetException x) {
		 			Throwable cause = x.getCause();
		 			InterfaceController.showMessage(cause.getMessage());
		 		}
			}
		} catch (SecurityException | IllegalArgumentException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void launchApp() {
		JPanel p = new JPanel();
		p.setBounds(0, 0, 584, 462);
		p.setLayout(null);
		p.add(new HeaderPanel());
		p.add(panel);
		Window.guiController.addPanel("App", p);
	    for(Interface i : Window.guiController.getAllInterfaces()) {
			Window.guiController.removePanel(i.getIdentity());
		}
		/*Method method;
		try {
			method = app.getDeclaredMethod("run");
			Object instance = app.newInstance();
			JPanel result = (JPanel) method.invoke(instance);
			Window.guiController.addPanel("App", result);
		    for(Interface i : Window.guiController.getAllInterfaces()) {
				Window.guiController.removePanel(i.getIdentity());
			}
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	public boolean install() {
		Object ans = InterfaceController.showDialog(new Object[] {"Yes", "No"}, "Are you sure you want to install " + Name + "?");
		if(ans == "Yes") {
			Installed = true;
			return true;
		}
		return false;
	}
	
	public boolean uninstall() {
		Object ans = InterfaceController.showDialog(new Object[] {"Yes", "No"}, "Are you sure you want to uninstall " + Name + "?");
		if(ans == "Yes") {
			Installed = false;
			return true;
		}
		return false;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public double getCost() {
		return Cost;
	}

	public void setCost(double cost) {
		Cost = cost;
	}
	
	
}