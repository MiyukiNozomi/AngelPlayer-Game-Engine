package api.shinoa.sdx;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class RawInput implements KeyListener, MouseListener,
		MouseMotionListener, MouseWheelListener {

	public boolean[] keys = new boolean[356];
	public boolean[] buttons = new boolean[9];
	public boolean msClicked, isInScreen,dragged;
	public int mx,my,wheel;
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		wheel = arg0.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		buttons[arg0.getButton()] = true;
		dragged = true;
		mx = arg0.getX();
		my = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mx = arg0.getX();
		my = arg0.getY();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		msClicked = true;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isInScreen = true;
		mx = arg0.getX();
		my = arg0.getY();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		buttons[arg0.getButton()] = false;
		msClicked = false;
		isInScreen = false;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		buttons[arg0.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		msClicked = false;
		buttons[arg0.getButton()] = false;
		dragged = false;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
