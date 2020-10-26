package api.shinoa.sdx.sgl3d.mesh;

public class PreLoadedMesh {

	public java.awt.Polygon[] polygons;
	
	public PreLoadedMesh(java.awt.Polygon... polygons) {
		this.polygons = new java.awt.Polygon[polygons.length];
		for(int i = 0; i < polygons.length; i++){
			this.polygons[i] = polygons[i];
		}
	}

}
