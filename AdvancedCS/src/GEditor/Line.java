package GEditor;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

	public Line(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawLine(x, y, x+width, y+height);
	}

	@Override
	public boolean isOn(int x, int y) {
		// TODO Auto-generated method stub

		double slope = (double)height / width;
		if((double)(x-this.x)/(y-this.y) - slope <= 5 &&
				(double)(x-this.x)/(y-this.y) - slope >= -5
				&& x>= this.x && x <= this.x+width
				&& y >= this.y && y <= this.y+height) return true;
		return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		width = x2-x1;
		height = y2-y1;
	}

}
