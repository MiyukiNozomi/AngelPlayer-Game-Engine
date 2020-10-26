package api.shinoa.sdx.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GlobalLoader {

	public static String defaultPackage = "/api/shinoa/sdx/deficons/";
	public static final BufferedImage ICON = loadIcon("icon");
	public static final BufferedImage LOGO = loadIcon("logo");
	
	public static BufferedImage loadIcon(String name) {
		try {
			return ImageIO.read(GlobalLoader.class.getResource(defaultPackage
					+ name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
			return null;
		}
	}

	public static ImageIcon loadIcon(String name, String ext) {
		return new ImageIcon(GlobalLoader.class.getResource(defaultPackage
				+ name + ext));
	}

	public static class Extensions {
		public static final String PNG = ".png",
				GIF = ".gif",
				BITMAP = ".bmp",
				JPG = ".jpg";
	}
}
