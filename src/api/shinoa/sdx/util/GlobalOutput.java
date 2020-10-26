package api.shinoa.sdx.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GlobalOutput {

	private String output;

	// @see this "target" is the path to the target folder
	public GlobalOutput(File target) {
		if (!target.isDirectory() || !target.exists()) {
			System.err.println("GlobalOutput>> This is not a valid folder: "
					+ target.getPath());
			return;
		}
		this.output = target.getPath();
	}

	public boolean fileExists(String name) {
		return new File(output + "\\" + name).exists();
	}

	// example: write("myfile.txt","owo");
	public boolean write(String filename, String data) {
		try {
			if (output == null)
				return false;
			Files.write(Paths.get(output + "\\" + filename), data.getBytes());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
