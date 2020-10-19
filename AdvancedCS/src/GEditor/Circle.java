package GEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Circle extends Shape{

	public Circle(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(c);
		g.fillOval(x-(int)(width/2), y-(int)(width/2), width, width);
		
	}

	@Override
	public boolean isOn(int x, int y) {
		// TODO Auto-generated method stub
		int dis = (int)(Math.sqrt(Math.pow(this.x-x, 2)+ Math.pow(this.y-y, 2)));
		if(dis >= 0 && dis <= width/2) return true;
		return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		if(x1 <= x2) {
			x = x1;
			width = x2 - x1;
		} else {
			x = x2;
			width = x1 - x2;
		}
		
		if(y1 <= y2) {
			y = y1;
			width = y2 - y1;
		} else {
			y = y2;
			width = y1 - y2;
		}
		
	}

}
