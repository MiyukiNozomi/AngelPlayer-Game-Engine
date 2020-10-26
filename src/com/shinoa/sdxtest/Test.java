package com.shinoa.sdxtest;

import java.awt.Color;
import java.awt.Graphics2D;

import api.shinoa.sdx.SDXProgram;
import api.shinoa.sdx.Window;
import api.shinoa.sdx.sgl3d.DX15;
import api.shinoa.sdx.sgl3d.DX20;
import api.shinoa.sdx.sgl3d.DX40;
import api.shinoa.sdx.sgl3d.DrawMode;
import api.shinoa.sdx.sgl3d.mesh.Mesh;
import api.shinoa.sdx.sgl3d.mesh.Polygon;
import api.shinoa.sdx.sgl3d.mesh.Vertex;

public class Test extends SDXProgram {

	private Mesh mesh;

	public Test() {
		super(new Window("Test",400,400),60);
		
		float s = 80;
		Vertex p1 = new Vertex(s/2,-s/2,-s/2);
		Vertex p2 = new Vertex(s/2,s/2,-s/2);
		Vertex p3 = new Vertex(s/2,s/2,s/2);
		Vertex p4 = new Vertex(s/2,-s/2,s/2);
		Vertex p5 = new Vertex(-s/2,-s/2,-s/2);
		Vertex p6 = new Vertex(-s/2,s/2,-s/2);
		Vertex p7 = new Vertex(-s/2,s/2,s/2);
		Vertex p8 = new Vertex(-s/2,-s/2,s/2);
		
		mesh = new Mesh(
				new Polygon(p1,p2,p3,p4),
				new Polygon(p5,p6,p7,p8),
				new Polygon(p2,p1,p5,p6),
				new Polygon(p1,p5,p8,p4),
				new Polygon(p2,p6,p7,p3),
				new Polygon(p4,p3,p7,p8));
	}

	@Override
	public void onStart() {
	}

	@Override
	public void onUpdate() {
		window.getFrame().setTitle("Test " + fps);
		DX20.rotateMesh(mesh,0.4f,0.4f,0.4f);
		mesh.polygons = DX20.sort(mesh.polygons);
	}

	@Override
	public void onDraw(Graphics2D g) {
		DX15.enableSGLAA(true);
		DX40.preProcess(mesh);
		DX40.drawMesh(Color.BLUE,DrawMode.BORDER_POLYGONS);
		DX40.delete();
	}

	@Override
	public void onStop() {

	}

	public static void main(String[] args) {
		new Test().start();
	}
}
