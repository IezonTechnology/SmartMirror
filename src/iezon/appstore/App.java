package iezon.appstore;

import iezon.interfaces.options.InterfaceController;

public class App {
	
	public String Name;
	public String Details;
	public double Cost;
	public boolean Installed = false;
	

	public App(String Name, String Details, double Cost) {
		this.Name = Name;
		this.Cost = Cost;
	}

	public boolean isInstalled () {
		// TODO: Confirm directory is installed
		return Installed;
	}
	
	public void launch() {
		InterfaceController.showMessage("Launching " + Name + " is soon to come!");
	}
	
	public void install() {
		Installed = true;
	}
	
	public void uninstall() {
		Installed = false;
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