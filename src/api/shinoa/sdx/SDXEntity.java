package api.shinoa.sdx;

import java.awt.Color;
import java.awt.Graphics2D;

import api.shinoa.sdx.sgl3d.DX20;
import api.shinoa.sdx.sgl3d.DX30;
import api.shinoa.sdx.sgl3d.DrawMode;
import api.shinoa.sdx.sgl3d.mesh.Mesh;
import api.shinoa.sdx.sgl3d.mesh.Polygon;
import api.shinoa.sdx.sgl3d.scn.Scene;

public class SDXEntity extends SDXObject {

	public Color material;
	
	public SDXEntity(Color material,Mesh... mesh) {
		super(mesh);
		
		this.material = material;
		
		for(Polygon p : polygons){
			p.setColor(material);
		}
	}

	@Override
	void onStart() {

	}

	@Override
	void onUpdate() {

	}

	@Override
	void onDraw(Graphics2D g) {
		for (Mesh m : mesh) {
			for(Polygon p : m.polygons){
				DX30.preProcess(p);
				Color d = p.getLight();
				if(d == null)
					DX30.drawPolygon(p.getBase(), DrawMode.BORDER_POLYGONS);
				else
					DX30.drawPolygon(d, DrawMode.FILLED_POLYGONS);
				DX30.delete();
			}
		}
		
	}
	@Override
	public void rotate(float x, float y, float z) {
		for (Mesh m : mesh) {
			DX20.rotateMesh(m, x, y,z,Scene.LIGHT);
		}
		sortPolygons();
	}
	
	public Color getMaterial() {
		return material;
	}
}
