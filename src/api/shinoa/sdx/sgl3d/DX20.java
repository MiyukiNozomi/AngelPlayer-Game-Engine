package api.shinoa.sdx.sgl3d;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import api.shinoa.sdx.SDXProgram;
import api.shinoa.sdx.math.FMath;
import api.shinoa.sdx.sgl2d.Vector2;
import api.shinoa.sdx.sgl3d.mesh.Mesh;
import api.shinoa.sdx.sgl3d.mesh.Polygon;
import api.shinoa.sdx.sgl3d.mesh.Vertex;

public class DX20 {

	public static Point toPoint(Vertex vertex) {
		Vector2 nValues = scale(vertex.y, vertex.z, vertex.x);

		int x2d = (int) (SDXProgram.getSize().width / 2 + nValues.x);
		int y2d = (int) (SDXProgram.getSize().height / 2 - nValues.y);

		return new Point(x2d, y2d);
	}

	public static Vector2 scale(float x3d, float y3d, float depth) {
		double dist = FMath.sqrt(x3d * x3d + y3d * y3d);
		double theta = FMath.atan2(y3d, x3d);
		double depth2 = 15 - depth;
		double localScale = FMath.abs(1400 / (depth2 + 1400));

		dist *= localScale;

		return new Vector2((float) (dist * FMath.cos(theta)),
				(float) (dist * FMath.sin(theta)));
	}

	public static final void rotateMesh(Mesh m, float x, float y, float z) {
		for (int i = 0; i < m.polygons.length; i++)
			rotatePolygon(m.polygons[i], x, y, z);
	}

	public static final void rotatePolygon(Polygon p, float x, float y, float z) {
		for (int i = 0; i < p.vertices.length; i++) {
			rotateX(p.vertices[i], x);
			rotateY(p.vertices[i], y);
			rotateZ(p.vertices[i], z);
		}
	}

	public static final void rotateX(Vertex v, float degress) {
		double radius = FMath.sqrt(v.y * v.y + v.z * v.z);
		double theta = FMath.atan2(v.z, v.y);
		theta += 2 * FMath.PI / 360 * degress * -1;
		v.y = (float) (radius * FMath.cos(theta));
		v.z = (float) (radius * FMath.sin(theta));
	}

	public static final void rotateY(Vertex v, float degress) {
		double radius = FMath.sqrt(v.x * v.x + v.z * v.z);
		double theta = FMath.atan2(v.z, v.x);
		theta += 2 * FMath.PI / 360 * degress * -1;
		v.x = (float) (radius * FMath.cos(theta));
		v.z = (float) (radius * FMath.sin(theta));
	}

	public static final void rotateZ(Vertex v, float degress) {
		double radius = FMath.sqrt(v.y * v.y + v.x * v.x);
		double theta = FMath.atan2(v.x, v.y);
		theta += 2 * FMath.PI / 360 * degress * -1;
		v.y = (float) (radius * FMath.cos(theta));
		v.x = (float) (radius * FMath.sin(theta));
	}

	public static final Polygon[] sort(Polygon[] polygons) {
		List<Polygon> polysAsList = new ArrayList<Polygon>();
		for (Polygon p : polygons) {
			polysAsList.add(p);
		}

		Collections.sort(polysAsList, new Comparator<Polygon>() {
			@Override
			public int compare(Polygon arg0, Polygon arg1) {
				return (int) (getAverageX(arg1) - getAverageX(arg0) < 0 ? 1 : -1);
			}
		});

		Polygon[] polys = new Polygon[polygons.length];
		for(int d = 0; d < polys.length; d++){
			polys[d] = polysAsList.get(d);
		}
		return polys;
	}

	public static final float getAverageX(Polygon p) {
		float sum = 0f;

		for (Vertex v : p.vertices) {
			sum += v.x;
		}

		return sum / p.vertices.length;
	}
}