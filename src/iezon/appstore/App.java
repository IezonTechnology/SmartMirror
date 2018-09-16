package iezon.appstore;

import java.awt.Component;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessControlException;
import javax.swing.JPanel;

import iezon.interfaces.AppliationStore;
import iezon.interfaces.HeaderPanel;
import iezon.interfaces.options.Interface;
import iezon.interfaces.options.InterfaceController;
import iezon.main.Window;
import iezon.security.AppSecurityManager;

public class App {
	
	private String 		name;
	private double 		cost;
	private String 		description;
	private String 		author;
	private Class<?> 	object;
	private URL			download;
	private boolean		installStatus = false;
	private int			id;
	private boolean		policy = false;
	
	public App(String name, double cost, String description, int id) {
		this.name = name;
		this.cost = cost;
		this.description = description;
		this.id = id;
	}
	
	public App setPolicy(boolean status) {
		policy = status;
		return this;
	}
	public boolean policyIsAgreedTo() {
		return policy;
	}
	
	
	public int getId() {
		return id;
	}
	
	public App setAuthor(String author) {
		this.author = author;
		return this;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public boolean isInstalled() {
		return installStatus;
	}
	
	public boolean install() {
		Object ans = InterfaceController.showDialog(new Object[] {"Yes", "No"}, "Are you sure you want to install " + name + "?");
		if(ans == "Yes") {
			URLClassLoader appLoader;
			Class<?> appBuilder = null;
			
			// TODO: Download file first
			// TODO: Check for updates

			try {
				appLoader = URLClassLoader.newInstance(new URL[] { download });
				appBuilder = appLoader.loadClass("iezon.app." + name);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			object = appBuilder;
			installStatus = true;
			return true;
		}
		return false;
	}
	
	public boolean uninstall() {
		Object ans = InterfaceController.showDialog(new Object[] {"Yes", "No"}, "Are you sure you want to uninstall " + name + "?");
		if(ans == "Yes")  {
			installStatus = false;
			return true;
		}
		return false;
	}
	
	public App setDownloadUrl(URL download) {
		this.download = download;
		return this;
	}
	
	public URL getDownloadUrl() {
		return download;
	}
	
	public Class<?> getObject() {
		return object;
	}
	
	public App setClass(Class<?> object) {
		this.object = object;
		return this;
	}
	
	public void launchApp() throws Exception {
		if(object == null)
			throw new Exception("Please re-install this app.");
		
		// TODO: Check for updates
		
		Object app;
		
		//try {
			/*SecurityManager sm = new SecurityManager();
			Object context = sm.getSecurityContext();
			sm.checkPermission(new AllPermission(), context);*/
			
			//app = object.newInstance();
		try {
			app = new AppSecurityManager("C:/Temp/" + name + ".policy").execute(this);
			JPanel p = new JPanel();
			p.setBounds(0, 0, 584, 462);
			p.setLayout(null);
			p.add(new HeaderPanel());
			// p.add((JPanel) app);
			p.add((JPanel) app);
			Window.guiController.addPanel(name, p);
			for(Interface i : Window.guiController.getAllInterfaces()) {
				Window.guiController.removePanel(i.getIdentity());
			}
		} catch (Exception e) {
			InterfaceController.showMessage(e.getMessage());
		}
		/*} catch (AccessControlException e) {
			InterfaceController.showMessage("Security flaw in " + name + "! " + e.getPermission().getActions());
			installStatus = false;
			// TODO: Report to appstore
		}*/
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getName() {
		return name;
	}
}
