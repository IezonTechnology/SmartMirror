package iezon.appstore;

public class App {
	
	public String Name;
	public String Details;
	public double Cost;
	public boolean Installed;
	

	public App(String Name, String Details, double Cost, boolean Installed) {
		this.Name = Name;
		this.Cost = Cost;
		this.Installed = Installed;
	}

	public void isInstalled (boolean Installed) {
		//check directory of install before installing
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