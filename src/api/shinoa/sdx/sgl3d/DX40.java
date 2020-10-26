package api.shinoa.sdx.sgl3d;

import static api.shinoa.sdx.sgl3d.DX30.to2DPolygon;
import static api.shinoa.sdx.sgl3d.DX30.g;

import java.awt.Color;

import api.shinoa.sdx.sgl3d.mesh.Mesh;
import api.shinoa.sdx.sgl3d.mesh.PreLoadedMesh;

public class DX40 {

	private static PreLoadedMesh preLoadedMesh;

	public static final void preProcess(Mesh m) {
		java.awt.Polygon[] polygon = new java.awt.Polygon[m.polygons.length];
		for (int i = 0; i < m.polygons.length; i++) {
			polygon[i] = to2DPolygon(m.polygons[i]);
		}
		preLoadedMesh = new PreLoadedMesh(polygon);
	}

	public static final void drawMesh(Color c, DrawMode mode) {
		if (preLoadedMesh != null) {
			g.setColor(c);

			switch (mode) {
			case BORDER_POLYGONS:
				for (java.awt.Polygon polygon : preLoadedMesh.polygons){
					g.drawPolygon(polygon);
				}
				break;
			case FILLED_POLYGONS:
				for (java.awt.Polygon polygon : preLoadedMesh.polygons)
					g.fillPolygon(polygon);
				break;
			}
		} else {
			throw new IllegalStateException("There is not pre Loaded Mesh.");
		}
	}

	public static final void delete() {
		preLoadedMesh = null;
	}

	public static PreLoadedMesh getPreLoadedMesh() {
		return preLoadedMesh;
	}

}
