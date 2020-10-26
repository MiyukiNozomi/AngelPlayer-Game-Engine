package api.shinoa.sdx;

public final class Input {

	public static final String MOUSE_X = "Mouse X", MOUSE_Y = "Mouse Y",MOUSE_WHEEL = "Mouse Wheel";
	private static RawInput in;
	
	static void init(RawInput input){
		in = input;
	}
	
	
	public static final int getAxis(String str) {
		switch (str) {
		case MOUSE_X:
			return in.mx;
		case MOUSE_Y:
			return in.my;
		case MOUSE_WHEEL:
			return in.wheel;
		}
		throw new IllegalArgumentException(str + " is not a valid axis name");
	}

	public static final boolean buttonUp(int button){
		if(button > in.buttons.length){
			throw new IllegalArgumentException(button + " is outside the RawInput.buttons length.");
		}
		return in.buttons[button];
	}
	
	public static final boolean isMouseDragged(){
		return in.dragged;
	}
	
	public static final boolean buttonClicked(){
		return in.msClicked;
	}
	
	public static final boolean mouseInScreen(){
		return in.isInScreen;
	}
	
	public static final boolean keyUp(int key){
		if(key > in.keys.length){
			throw new IllegalArgumentException(key + " is outside the RawInput.keys length.");
		}
		return in.keys[key];
	}
	
	
}
