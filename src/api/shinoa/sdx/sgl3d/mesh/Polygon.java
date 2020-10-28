package api.shinoa.sdx.sgl3d.mesh;

import java.awt.Color;

public class Polygon {

	public Vertex[] vertices;
	private Color base, light;

	public Polygon(Vertex... vertices) {
		this.vertices = new Vertex[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			this.vertices[i] = new Vertex(vertices[i].x, vertices[i].y,
					vertices[i].z);
		}
	}

	public void setColor(Color c) {
		this.base = c;
	}

	public void updateLight(float lightRatio) {
		int red = (int) (this.base.getRed() * lightRatio);
		int green = (int) (this.base.getGreen() * lightRatio);
		int blue = (int) (this.base.getBlue() * lightRatio);
		this.light = new Color(red, green,blue);
	}

	public Color getBase() {
		return base;
	}

	public Color getLight() {
		return light;
	}
}
