package api.shinoa.sdx.sgl3d.mesh;

public class Mesh {

	public Polygon[] polygons;
	
	public Mesh(Polygon... polygons){
		this.polygons = new Polygon[polygons.length];
		for(int i = 0; i < polygons.length; i++){
			this.polygons[i] = polygons[i];
		}
	}
}
