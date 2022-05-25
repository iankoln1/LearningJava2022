import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class FightingGame extends JPanel implements Runnable  {

	final int originalTileSize = 16;
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	Thread gameThread;
	
	public FightingGame() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void run() {
		while(gameThread != null) {
			
			
			update();
			
			repaint();
			
		}
		
	}
	public void update() {
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(100,100, tileSize,tileSize);
		g2.dispose();
	}
}
