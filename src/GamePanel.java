import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{
	Timer alienSpawn; 
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Font titleFont=new Font("Arial",Font.PLAIN,48);
	Font sub=new Font("Arial",Font.PLAIN,20);
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    RocketShip rocket=new RocketShip(250,700,50,50);
    Objectmanager objectmanager=new Objectmanager(rocket);
    GamePanel(){
    	if (needImage) {
    	    loadImage ("space.png");
    	}
    	 Timer frameDraw = new Timer(1000/60,this);
    	    frameDraw.start();
    	
    }
    
   void startgame(){
	   alienSpawn = new Timer(1000 , objectmanager);
	    alienSpawn.start();
    	
    }
    
    void updateMenuState() {
    	
    }
    void updateGameState() { 
    	
    }
    void updateEndState()  {
    	
    }
    
    
    void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("League Invaders", 50, 200);
    	g.setFont(sub);
    	g.setColor(Color.yellow);
    	g.drawString("Press ENTER to Start", 130, 400);
    	g.setFont(sub);
    	g.setColor(Color.yellow);
    	g.drawString("Press SPACE for instructions", 110, 500);
    }
    void drawGameState(Graphics g) { 
    	if (gotImage) {
    		g.drawImage(image, 0, 0, LeagueInvaders.WIDTH,LeagueInvaders.HIEGHT, null);
    	} else {
    		g.setColor(Color.BLUE);
    		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);
    	}
    
    	rocket.draw(g);
    }
    void drawEndState(Graphics g)  { 
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("END GAME", 100, 200);
    	g.setFont(sub);
    	g.setColor(Color.yellow);
    	g.drawString("You killed enemies", 130, 400);
    	g.setFont(sub);
    	g.setColor(Color.yellow);
    	g.drawString("Press Enter to restart", 110, 500);
    }

    
   
    
@Override
public void paintComponent(Graphics g){
	if(currentState == MENU){
	    drawMenuState(g);
	}else if(currentState == GAME){
	    drawGameState(g);
	}else if(currentState == END){
	    drawEndState(g);
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
if(currentState == MENU){
    updateMenuState();
}else if(currentState == GAME){
    updateGameState();
}else if(currentState == END){
    updateEndState();}
  
    repaint();
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    if (currentState == END) {
	    	alienSpawn.stop();
	        currentState = MENU;
	    } if(currentState == GAME){
	    	startgame();
	    }else {
	        currentState++;
	    }
	   
	}
	 if (e.getKeyCode()==KeyEvent.VK_UP) {
	        rocket.up();
	    }
	    if (e.getKeyCode()==KeyEvent.VK_DOWN) {
	       rocket.down();
	    }
	    if (e.getKeyCode()==KeyEvent.VK_LEFT) {
	       rocket.left();
	    }
	    if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
	        rocket.right();
	    }
	    if (e.getKeyCode()==KeyEvent.VK_SPACE) {
	    	
	    	if(currentState==GAME) {
	    		objectmanager.addProjectile(rocket.getProjectile());
	    		
	    	}
	    }
	    
}
void loadImage(String imageFile) {
    if (needImage) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    gotImage = true;
        } catch (Exception e) {
            
        }
        needImage = false;
    }
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	

}



}
