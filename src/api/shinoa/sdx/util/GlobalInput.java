package api.shinoa.sdx.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GlobalInput {

	private String output;
	public static final String ERROR = "&&&&)#$@#$)$)@###@!#@!$r!@%!%!@";
	
	public GlobalInput(File target) {
		if (!target.isDirectory() || !target.exists()) {
			System.err.println("GlobalInput>> This is not a valid folder: "
					+ target.getPath());
			return;
		}
		this.output = target.getPath();
	}

	public boolean fileExists(String name) {
		return new File(output + "\\" + name).exists();
	}

	// example: read("myfile.txt");
	public String read(String filename) {
		try {
			if (output == null)
				return ERROR;
			return new String(Files.readAllBytes(Paths.get(output + "\\" + filename)));
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public File[] listFiles() {
		return new File(output).listFiles();
	}

	public int fileCount() {
		return new File(output).listFiles().length;
	}

	public String getOutput() {
		return output;
	}

}
