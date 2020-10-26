package api.shinoa.sdx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import api.shinoa.sdx.cmd.CustomSTDOUT;
import api.shinoa.sdx.sgl3d.DX30;
import api.shinoa.sdx.util.GlobalLoader;

public abstract class SDXProgram implements Runnable {
	
	protected Window window;
	protected Thread thread;
	protected boolean isRunning;
	protected int fixed;
	protected int fps;
	protected static Dimension size;
	
	public SDXProgram(Window window,int fixed) {
		this.window = window;
		SDXProgram.size = this.window.getSize();
		this.fixed = fixed;
		
		System.setOut(new CustomSTDOUT(System.out,"INFO"));
		System.setErr(new CustomSTDOUT(System.err,"ERROR"));
	
		System.out.println("ShinoaGL Version: " + SDX.SGL_VERSION + ",SDX Version: " + SDX.SDX_VERSION);
	}
	
	public synchronized void start(){
		thread = new Thread(this,"SDXProgram");
		thread.setPriority(Thread.NORM_PRIORITY);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop(){
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	final float maxTimer = 0;
	float timer = 1.0f;
	
	private void draw(){
		BufferStrategy bs = window.getBufferStrategy();
		if(bs == null){
			window.createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		DX30.updateContext(g);
		g.clearRect(0, 0, window.getMaximumSize().width,window.getMinimumSize().height);
	
		if(timer > maxTimer){
			drawLogo(g);
		}else{
			onDraw(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void drawLogo(Graphics2D g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0,size.width,size.height);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, timer));
		g.setColor(Color.BLACK);
		g.fillRect(0,0,size.width,size.height);
		g.drawImage(GlobalLoader.LOGO,10,size.height / 2,null);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0));
		timer -= 0.006f;
	}
	
	@Override
	public void run() {
		onStart();
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double nanoseconds = 1000000000 / fixed;
		double delta = 0;
		
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime) / nanoseconds;
			lastTime = now;
		
			while(delta >= 1){
				onUpdate();
				fps++;
				draw();
				delta--;
			}
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				fps = 0;
			}
		}
		
		
		onStop();
		stop();
	}

	public static Dimension getSize() {
		return size;
	}
	
	public abstract void onStart();
	public abstract void onUpdate();
	public abstract void onDraw(Graphics2D g);
	public abstract void onStop();
}
