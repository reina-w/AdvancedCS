package GEditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsEditor {

	private final int WIDTH = 800, HEIGHT = 700, BHEIGHT = 100;
	private int xLoc=0, yLoc=0;
	private Color cirColor = Color.YELLOW;
	private Color rectColor = Color.BLUE;
	private int mode = 0;
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	
	public GraphicsEditor() {
		
		JPanel panel = new JPanel();
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.setBorder(BorderFactory.createTitledBorder("Graphics Editor"));

		
		JButton circleButton = new JButton("Circle");
		circleButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mode = 1;
			}
		});
		
		JButton rectButton = new JButton("Rectangle");
		rectButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mode = 2;
			}
		});
		
		JButton deleButton = new JButton("Delete");
		deleButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mode = -1;
			}
		});
		
		JPanel innerPanel = new JPanel();
		innerPanel.setBackground(Color.gray);
		innerPanel.setPreferredSize(new Dimension(WIDTH, BHEIGHT));
		innerPanel.add(circleButton);
		innerPanel.add(rectButton);
		innerPanel.add(deleButton);
		panel.add(innerPanel);
		
		JPanel drawPanel = new JPanel(){
			
			public void paint(Graphics g) {
				
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, WIDTH, HEIGHT);
				for(int i=0; i< shapeList.size(); i++) {
					shapeList.get(i).draw(g);
				}
				
			}
		};
		
		drawPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT-BHEIGHT));
		panel.add(drawPanel);
		
		JFrame frame = new JFrame();
		
		drawPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				xLoc = e.getX();
				yLoc = e.getY();
				
				if(mode == 1) {
					Circle cir = new Circle(xLoc, yLoc, 0, 0, cirColor);
					shapeList.add(cir);
					
				} else if(mode == 2){
					Rectangle rect = new Rectangle(xLoc, yLoc, 0, 0, rectColor);
					shapeList.add(rect);
					
				} else if(mode == -1) {
					for(int i=0; i< shapeList.size(); i++) {
						if(shapeList.get(i).isOn(xLoc, yLoc)) {
							shapeList.remove(i);
						}
					}
				}
				frame.getContentPane().repaint();
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		drawPanel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(mode == 1 || mode == 2) {
					int size = shapeList.size();
					int x2 = e.getX();
					int y2 = e.getY();
					shapeList.get(size-1).resize(xLoc, yLoc, x2, y2);
				}
				frame.getContentPane().repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		panel.setFocusable(true);
		
		
		
	}
	
	

	public static void main(String[] args) {
		new GraphicsEditor();
	}

}
