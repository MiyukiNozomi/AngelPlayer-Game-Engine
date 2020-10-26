package api.shinoa.sdx;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import api.shinoa.sdx.util.GlobalLoader;

public class Window extends Canvas {
	
	/**
	 * @author Shinoa
	 * @since 2019
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	
	public Window(String UTFTitle,int width,int height){
		Dimension size = new Dimension(width,height);
		frame = new JFrame(UTFTitle);
		frame.setSize(size);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(GlobalLoader.ICON);
		
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		setFocusable(false);
		
		RawInput input = new RawInput();
		addKeyListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);
		addMouseWheelListener(input);
		requestFocus();
		Input.init(input);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public final Dimension getSize(){
		return frame.getSize();
	}
}
