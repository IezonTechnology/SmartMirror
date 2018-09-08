package iezon.main;

import iezon.updates.UpdateController;

public class Init {
	
	private UpdateController uc = new UpdateController();

	public Init() {
		// uc.update();
		Window.run();
	}

	public static void main(String[] args) {
		new Init();
	}

}
