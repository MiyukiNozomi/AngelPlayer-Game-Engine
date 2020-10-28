package api.shinoa.sdx.util;

import java.util.ArrayList;
import java.util.List;

import api.shinoa.sdx.sgl3d.Vector3;
import api.shinoa.sdx.sgl3d.mesh.Mesh;
import api.shinoa.sdx.sgl3d.mesh.Polygon;
import api.shinoa.sdx.sgl3d.mesh.Vertex;

public class MeshGenerator {

	public static final Mesh DIAMOND = getDiamond(new Vector3(0, 0, 0), 2);
	public static final Mesh[] RUBIKS_CUBE = getRubikCube(new Vector3(), 2).toArray(new Mesh[0]);
	
	private static List<Mesh> getRubikCube(Vector3 center, float size) {
		List<Mesh> mesh = new ArrayList<Mesh>();

		double cubeSpacing = 1;

		for (int i = -1; i < 2; i++) {
			float cubeCenterX = (float) (i * (size + cubeSpacing) + center.x);
			for (int j = -1; j < 2; j++) {
				float cubeCenterY = (float) (j * (size + cubeSpacing) + center.y);
				for (int k = -1; k < 2; k++) {
					if (i == 0 && j == 0 && k == 0)
						continue;
					float cubeCenterZ = (float) (k * (size + cubeSpacing) + center.z);
					Vertex v1 = new Vertex(cubeCenterX - size / 2, cubeCenterY
							- size / 2, cubeCenterZ - size / 2);
					Vertex v2 = new Vertex(cubeCenterX - size / 2, cubeCenterY
							- size / 2, cubeCenterZ + size / 2);
					Vertex v3 = new Vertex(cubeCenterX - size / 2, cubeCenterY
							+ size / 2, cubeCenterZ - size / 2);
					Vertex v4 = new Vertex(cubeCenterX - size / 2, cubeCenterY
							+ size / 2, cubeCenterZ + size / 2);
					Vertex v5 = new Vertex(cubeCenterX + size / 2, cubeCenterY
							- size / 2, cubeCenterZ - size / 2);
					Vertex v6 = new Vertex(cubeCenterX + size / 2, cubeCenterY
							- size / 2, cubeCenterZ + size / 2);
					Vertex v7 = new Vertex(cubeCenterX + size / 2, cubeCenterY
							+ size / 2, cubeCenterZ - size / 2);
					Vertex v8 = new Vertex(cubeCenterX + size / 2, cubeCenterY
							+ size / 2, cubeCenterZ + size / 2);
					
					Polygon p1 = new Polygon(v5,v6,v8,v7);
					Polygon p2 = new Polygon(v2,v4,v8,v6);
					Polygon p3 = new Polygon(v3,v4,v8,v7);
					Polygon p4 = new Polygon(v1,v2,v6,v5);
					Polygon p5 = new Polygon(v1,v2,v4,v3);
					Polygon p6 = new Polygon(v1,v3,v7,v5);
					
					Mesh nMesh = new Mesh(p1,p2,p3,p4,p5,p6);
					mesh.add(nMesh);
				}
			}
		}

		return mesh;
	}

	private static Mesh getDiamond(Vector3 center, float size) {
		float inFactor = 0.8f;
		int edges = 10;
		Vertex bottom = new Vertex(center.x, center.y, center.z - size / 2);
		Vertex[] outerPoints = new Vertex[edges];
		Vertex[] innerPoints = new Vertex[edges];

		for (int i = 0; i < edges; i++) {
			float theta = (float) (2 * Math.PI / edges * i);
			float xPos = (float) -Math.sin(theta) * size / 2;
			float yPos = (float) Math.cos(theta) * size / 2;
			float zPos = size / 2;
			outerPoints[i] = new Vertex(center.x + xPos, center.y + yPos,
					center.z + zPos * inFactor);
			innerPoints[i] = new Vertex(center.x + xPos * inFactor, center.y
					+ yPos * inFactor, center.z + zPos);
		}

		Polygon[] polygons = new Polygon[2 * edges + 1];
		for (int g = 0; g < edges; g++) {
			polygons[g] = new Polygon(outerPoints[g], bottom,
					outerPoints[(g + 1) % edges]);
		}

		for (int s = 0; s < edges; s++) {
			polygons[s + edges] = new Polygon(outerPoints[s],
					outerPoints[(s + 1) % edges], innerPoints[(s + 1) % edges],
					innerPoints[s]);
		}

		polygons[edges * 2] = new Polygon(innerPoints);

		System.out.println(polygons.length);

		return new Mesh(polygons);
	}

}