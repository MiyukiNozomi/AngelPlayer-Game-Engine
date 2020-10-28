package api.shinoa.sdx;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import api.shinoa.sdx.sgl3d.DX20;
import api.shinoa.sdx.sgl3d.mesh.Mesh;
import api.shinoa.sdx.sgl3d.mesh.Polygon;

public abstract class SDXObject {
	
	protected List<Mesh> mesh;
	protected Polygon[] polygons;
	
	public SDXObject(Mesh... mesh) {
		this.mesh = new ArrayList<Mesh>();
		List<Polygon> polygons = new ArrayList<Polygon>();
		
		for(Mesh m : mesh){
			this.mesh.add(m);
			polygons.addAll(Arrays.asList(m.polygons));
		}
		
		this.polygons = polygons.toArray(new Polygon[0]);
		
		sortPolygons();
	}
	
	abstract void onStart();
	abstract void onUpdate();
	abstract void onDraw(Graphics2D g);
	
	public abstract void rotate(float x,float y,float z);
	
	protected void sortPolygons(){	
		this.polygons = DX20.sort(polygons);
	}
	
	public Polygon[] getPolygons() {
		return polygons;
	}
	
	public List<Mesh> getMesh() {
		return mesh;
	}
}
