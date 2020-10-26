package api.shinoa.sdx.sgl3d;

import static api.shinoa.sdx.sgl3d.DX20.toPoint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import api.shinoa.sdx.sgl3d.mesh.Polygon;

public class DX30 {

	static Graphics2D g;
	private static java.awt.Polygon loadedPolygon;

	public static final void preProcess(Polygon pl) {
		loadedPolygon = new java.awt.Polygon();

		for (int i = 0; i < pl.vertices.length; i++) {
			Point p = toPoint(pl.vertices[i]);
			loadedPolygon.addPoint(p.x, p.y);
		}
	}

	public static final java.awt.Polygon to2DPolygon(Polygon pl) {
		java.awt.Polygon loadedPolygon = new java.awt.Polygon();

		for (int i = 0; i < pl.vertices.length; i++) {
			Point p = toPoint(pl.vertices[i]);
			loadedPolygon.addPoint(p.x, p.y);
		}
		return loadedPolygon;
	}

	public static final void drawPolygon(Color c, DrawMode mode) {
		if (loadedPolygon != null) {
			g.setColor(c);
			switch (mode) {
			case BORDER_POLYGONS:
				g.drawPolygon(loadedPolygon);
				break;
			case FILLED_POLYGONS:
				g.fillPolygon(loadedPolygon);
				break;
			}
		} else {
			throw new IllegalStateException("There is not pre Loaded Polygon.");
		}
	}

	public static final void delete() {
		loadedPolygon = null;
	}

	public static final void updateContext(Graphics2D gr) {
		g = gr;
	}
	
	public static java.awt.Polygon getLoadedPolygon() {
		return loadedPolygon;
	}
}
