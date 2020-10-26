package api.shinoa.sdx.sgl2d;

import java.io.Serializable;

public class Vector2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public float x,y;

	public Vector2(float x,float y) {
		this.x = x;
		this.y = y;
	}
	
}
