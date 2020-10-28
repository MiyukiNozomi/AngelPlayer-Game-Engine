package com.shinoa.sdxtest;

import java.awt.Color;
import java.awt.Graphics2D;

import api.shinoa.sdx.DXEntityManager;
import api.shinoa.sdx.SDXEntity;
import api.shinoa.sdx.SDXProgram;
import api.shinoa.sdx.Window;
import api.shinoa.sdx.sgl3d.mesh.Mesh;
import api.shinoa.sdx.util.MeshGenerator;

public class Test extends SDXProgram {

	private static Mesh mesh;
	private DXEntityManager manager;

	public Test() {
		super(new Window("Test", 800, 600), 60);
	}

	@Override
	public void onStart() {
		mesh = MeshGenerator.DIAMOND;
		manager = new DXEntityManager();
		manager.addEntity(new SDXEntity(Color.LIGHT_GRAY,mesh));
		manager.getObjects().get(0).rotate(0f,30f,0f);
		manager.onStart();
	}

	@Override
	public void onUpdate() {
		manager.onUpdate();
		manager.getObjects().get(0).rotate(0f,0f,0.4f);
		window.getFrame().setTitle("Test FPS: " + fps);
	}

	@Override
	public void onDraw(Graphics2D g) {
		manager.onDraw(g);
	}

	@Override
	public void onStop() {

	}

	public static void main(String[] args) {
		new Test().start();
	}
}
