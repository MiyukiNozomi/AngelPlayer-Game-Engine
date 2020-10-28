package api.shinoa.sdx;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class DXEntityManager {

	private List<SDXObject> objects = new ArrayList<SDXObject>();
	
	public DXEntityManager() {
		
	}
	
	public void onStart(){ //called in startup.
		for (SDXObject entity : objects) {
			entity.onStart();
		}
	}
	
	public void onUpdate(){ //this method is called 60 times in one second.
		for (SDXObject entity : objects) {
			entity.onUpdate();
		}
	}
	
	public void onDraw(Graphics2D g){ //same thing as onUpdate.
		for (SDXObject entity : objects) {
			entity.onDraw(g);
		}
	}
	
	public void addEntity(SDXObject entity){
		objects.add(entity);
	}
	
	public List<SDXObject> getObjects() {
		return objects;
	}
}
