package api.shinoa.sdx.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import api.shinoa.sdx.sgl3d.mesh.Mesh;
import api.shinoa.sdx.sgl3d.mesh.Polygon;
import api.shinoa.sdx.sgl3d.mesh.Vertex;

public class GlobalLoader {

	public static String defaultPackage = "/api/shinoa/sdx/";
	public static final BufferedImage ICON = loadIcon("icon");
	public static final BufferedImage LOGO = loadIcon("logo");
	public static final BufferedImage BLUE_LOGO = loadIcon("bluelogo");
	
	public static BufferedImage loadIcon(String name) {
		try {
			return ImageIO.read(GlobalLoader.class.getResource(defaultPackage
					+ "resources/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
			return null;
		}
	}

	public static ImageIcon loadIcon(String name, String ext) {
		return new ImageIcon(GlobalLoader.class.getResource(defaultPackage
				+ "icons/" + name + ext));
	}

	public static final Mesh loadSObject(String name) {
		Mesh model = null;
		try {
			FileReader isr = null;
			File objFile = new File(GlobalLoader.class.getResource(
					defaultPackage + "models/" + name + ".sobj").toURI());
			isr = new FileReader(objFile);
			BufferedReader reader = new BufferedReader(isr);
			List<Vertex> points = new ArrayList<Vertex>();
			List<Polygon> polygons = new ArrayList<Polygon>();

			String line;

			while (true) {
				line = reader.readLine();
				if (line.startsWith("vertex ")) {
					String[] currentLine = line.split(" ");
					Vertex point = new Vertex(
							(float) Float.valueOf(currentLine[1]),
							(float) Float.valueOf(currentLine[2]),
							(float) Float.valueOf(currentLine[3]));
					points.add(point);
				} else if (line.startsWith("polygon ")) {
					String[] currentLine = line.split(" ");

					Polygon newPolygon = null;
					List<Vertex> plt = new ArrayList<Vertex>();
					for (int o = 1; o < currentLine.length; o++) {
						plt.add(points.get(Integer.parseInt(currentLine[o])));
					
					}

					newPolygon = new Polygon(
							plt.toArray(new Vertex[plt.size()]));
					polygons.add(newPolygon);

				} else if (line.startsWith("[endmodel]")) {
					break;
				}
			}

			reader.close();

			Polygon[] polygond = polygons.toArray(new Polygon[polygons.size()]);

			model = new Mesh(polygond);

			return model;
		} catch (Exception e) {
			System.err.println("[GlobalLoader]> Can't Load: " + name);
			System.err.println("Stacktrace: ");
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}

	public static class Extensions {
		public static final String PNG = ".png", GIF = ".gif", BITMAP = ".bmp",
				JPG = ".jpg";
	}
}
