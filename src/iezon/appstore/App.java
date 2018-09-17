package iezon.appstore;

import java.awt.Component;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessControlException;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import iezon.interfaces.AppliationStore;
import iezon.interfaces.HeaderPanel;
import iezon.interfaces.SecurityPolicy;
import iezon.interfaces.options.Interface;
import iezon.interfaces.options.InterfaceController;
import iezon.main.Window;
import iezon.security.AppSecurityManager;

public class App {

	private String name;
	private double cost;
	private String description;
	private String author;
	private Class<?> object;
	private URL download;
	private boolean installStatus = false;
	private int id;
	private boolean policy = false;

	public App(String name, double cost, String description, int id) {
		this.name = name;
		this.cost = cost;
		this.description = description;
		this.id = id;
		
		// Check security policy exists and file exists
		File policy = new File("C:/Temp/" + name + ".policy"), app = new File("C:/Temp/" + name + ".jar");
		installStatus = app.exists() && policy.exists() ? true : false;
		if(installStatus) {
			try {
				download = new URL("file:C:/Temp/" + name + ".jar");
			} catch (MalformedURLException e) {
				return;
			}
			quiteInstall();
		}
		try {
			AppSecurityManager asm = new AppSecurityManager("C:/Temp/" + name + ".policy");
			if(asm.readPolicy(this).toString().contains("{"))
				this.policy = true;
		} catch (Exception e) {
			return;
		}
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
	
	private void quiteInstall() {
		URLClassLoader appLoader;
		Class<?> appBuilder = null;
		
		try {
			appLoader = URLClassLoader.newInstance(new URL[] { download });
			appBuilder = appLoader.loadClass("iezon.app." + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		object = appBuilder;
		installStatus = true;
	}

	public boolean install() {
		Object ans = InterfaceController.showDialog(new Object[] { "Yes", "No" },
				"Are you sure you want to install " + name + "?");
		if (ans == "Yes") {
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
		Object ans = InterfaceController.showDialog(new Object[] { "Yes", "No" },
				"Are you sure you want to uninstall " + name + "?");
		if (ans == "Yes") {
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

	public boolean launchApp() throws Exception {
		if (object == null) {
			InterfaceController.showMessage("This app needs to be reinstalled.");
			while(installStatus)
				uninstall();
			throw new Exception("Please re-install this app.");
		}

		// TODO: Check for updates

		Object app;
		AppSecurityManager asm = null;

		try {
			asm = new AppSecurityManager("C:/Temp/" + name + ".policy");
			app = asm.execute(this);
		} catch (Exception e) {
			return false;
		}
		JPanel p = new JPanel();
		p.setBounds(0, 0, 584, 462);
		p.setLayout(null);
		p.add(new HeaderPanel());
		p.add(app == null ? new SecurityPolicy() : (JPanel) app);
		Window.guiController.addPanel(name, p);
		for (Interface i : Window.guiController.getAllInterfaces()) {
			Window.guiController.removePanel(i.getIdentity());
		}
		return true;

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
