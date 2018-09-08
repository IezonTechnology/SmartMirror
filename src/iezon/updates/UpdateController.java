package iezon.updates;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class UpdateController {

	public UpdateController() {
		File file = new File("C:/Temp/SmartMirror.zip");
		if (file.exists()) {
			
		}
	}
	
	public void update() {
		try {
			File file = new File("C:/Temp/SmartMirror.zip");
			URL url = new URL("https://codeload.github.com/IezonTechnology/SmartMirror/zip/master");
			copyUrlToFile(url, file);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private void copyUrlToFile(URL url, File file) {
		try {
			InputStream input = url.openStream();
			if (file.exists()) {
				if (file.isDirectory())
					throw new IOException("File '" + file + "' is a directory");
				if (!file.canWrite())
					throw new IOException("File '" + file + "' cannot be written");
			} else {
				File parent = file.getParentFile();
				if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
					throw new IOException("File '" + file + "' could not be created");
				}
			}
			FileOutputStream output = new FileOutputStream(file);
			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
			}
			input.close();
			output.close();
		} catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
	}

}
