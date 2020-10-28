package api.shinoa.sdx.sgl3d;

import api.shinoa.sdx.math.FMath;
import api.shinoa.sdx.sgl3d.mesh.Vertex;

public class Vector3 {
	
	public float x,y,z;
	
	public Vector3(float x,float y,float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
	}
	
	public Vector3(Vertex v1,Vertex v2){
		this.x = v2.x - v1.x;
		this.y = v2.y - v1.y;
		this.z = v2.z - v1.z;
	}
	
	public static float dot(Vector3 v1,Vector3 v2){
		return v1.x*v2.x + v1.y * v2.y + v1.z * v2.z;
	}
	
	public static final Vector3 normalize(Vector3 v){
		float magnitude = FMath.sqrt(v.x*v.x + v.y*v.y);
		return new Vector3(v.x/magnitude,v.y/magnitude,v.z/magnitude);
	}
	
	public static Vector3 cross(Vector3 v1,Vector3 v2){
		return new Vector3(
				v1.y * v2.z - v1.z *v2.y,
				v1.z*v2.x - v1.x*v2.z,
				v1.x*v2.y - v1.y*v2.x);
	}
	
}