package api.shinoa.sdx.sgl3d.mesh;

public class Polygon {
	
	public Vertex[] vertices;
	
	public Polygon(Vertex... vertices) {
		this.vertices = new Vertex[vertices.length];
		for(int i = 0; i < vertices.length; i++){
			this.vertices[i] = new Vertex(vertices[i].x,vertices[i].y,vertices[i].z);
		}
	}
}
