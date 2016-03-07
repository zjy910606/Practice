
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NewSnakeGame extends JPanel implements ActionListener{
	
	private static final int HEIGHT = 20;
	private static final int WIDTH = 60;
	private static Point food = new Point();
	private static LinkedList<Point> snake = new LinkedList<Point>();
	private char[][] map = new char[HEIGHT][WIDTH];
	
	private Timer t;
	private static final int UP = 1;
	private static final int DOWN = -1;
	private static final int RIGHT = 2;
	private static final int LEFT = -2;
	
	private static int CURRENTDIRECTION = RIGHT;
	
	private void iniMap() {
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 60; j++) {
				if(i==0||i==19||j==0||j==59)
					map[i][j] = '*';
				else
					map[i][j] = ' ';
			}
		t = new Timer(1000,this);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==t)
			move();
	}
	
	private void showMap() {
		iniMap();
		iniSnake();
		iniFood();
		showSnake();
		showFood();
		paint(getGraphics());
//		paint();
	}
	
	public void refresh() {
		iniMap();
		showSnake();
		showFood();
		repaint();
//		paint();
	}
	
	private void iniSnake() {
		snake.add(new Point(HEIGHT/2, WIDTH/2));
		snake.add(new Point(HEIGHT/2, WIDTH/2-1));
		snake.add(new Point(HEIGHT/2, WIDTH/2-2));
		map[snake.getFirst().x][snake.getFirst().y] = '&';
		for(int i = 1; i < snake.size(); i++)
			map[snake.get(i).x][snake.get(i).y] = '#';
	}
	
	private void showSnake() {
		map[snake.getFirst().x][snake.getFirst().y] = '&';
		for(int i = 1; i < snake.size(); i++)
			map[snake.get(i).x][snake.get(i).y] = '#';
	}
	
	private void iniFood() {
		boolean flag = true;
		while(flag) {
			int x = (int) (Math.random()*20);
			int y = (int) (Math.random()*60);
			if(map[x][y]==' '){
				food = new Point(x,y);
				map[x][y] = '$';
				flag = false;
			}
		}
	}
	
	private void showFood() {
		map[food.x][food.y] = '$';
	}
	
	public void paint() {
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 60; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 60; j++) {
				if(map[i][j]=='*'){
					g.setColor(Color.GRAY);
					g.fill3DRect(j*20, i*20, 20, 20, true);
				}else if(map[i][j]==' '){
					g.setColor(Color.WHITE);
					g.fill3DRect(j*20, i*20, 20, 20, true);
				}else if(map[i][j]=='&'){
					g.setColor(Color.RED);
					g.fill3DRect(j*20, i*20, 20, 20, true);
				}else if(map[i][j]=='#'){
					g.setColor(Color.GREEN);
					g.fill3DRect(j*20, i*20, 20, 20, true);
				}else if(map[i][j]=='$'){
					g.setColor(Color.BLUE);
					g.fill3DRect(j*20, i*20, 20, 20, true);
				}
			}
		if(die()){
			g.setColor(Color.RED);
			g.setFont(new Font("Calibri",Font.BOLD,30));
			g.drawString("Game Over", 500, 200);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	public void moveUp() {
		snake.addFirst(new Point(snake.getFirst().x-1,snake.getFirst().y));
		if(!eatFood())
			snake.removeLast();
	}
	
	public void moveDown() {
		snake.addFirst(new Point(snake.getFirst().x+1,snake.getFirst().y));
		if(!eatFood())
			snake.removeLast();
	}
	
	public void moveRight() {
		snake.addFirst(new Point(snake.getFirst().x,snake.getFirst().y+1));
		if(!eatFood())
			snake.removeLast();
	}
	
	public void moveLeft() {
		snake.addFirst(new Point(snake.getFirst().x,snake.getFirst().y-1));
		if(!eatFood())
			snake.removeLast();
	}
	
	public boolean eatFood() {
		if(food.equals(snake.getFirst())) {
			iniFood();
			return true;
		}
		return false;
	}
	
	public void move() {
		switch(CURRENTDIRECTION) {
			case UP:
				moveUp();
				refresh();
				break;
			case DOWN:
				moveDown();
				refresh();
				break;
			case RIGHT:
				moveRight();
				refresh();
				break;
			case LEFT:
				moveLeft();
				refresh();
				break;
		}
	}
	
	public boolean die() {
		if(snake.getFirst().x==0||snake.getFirst().y==0||snake.getFirst().x==19||snake.getFirst().y==59)
			return true;
		return false;
	}
	
	public void changeDirection(int d) {
		if(CURRENTDIRECTION + d ==0)
			return;
		CURRENTDIRECTION = d;
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();
		NewSnakeGame g = new NewSnakeGame();
		frame.add(g);
		FrameUtil.initFrame(frame, 1220, 440);
		g.iniMap();
		g.showMap();
		
		frame.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch(code) {
					case KeyEvent.VK_UP:
						g.changeDirection(UP);
						g.move();
						break;
					case KeyEvent.VK_DOWN:
						g.changeDirection(DOWN);
						g.move();
						break;
					case KeyEvent.VK_RIGHT:
						g.changeDirection(RIGHT);
						g.move();
						break;
					case KeyEvent.VK_LEFT:
						g.changeDirection(LEFT);
						g.move();
						break;
					default:
						g.move();
						break;
				}
			}
		});
	}

}
