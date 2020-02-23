import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{

	Font titleFont=new Font("Arial",Font.PLAIN,48);
	Font sub=new Font("Arial",Font.PLAIN,20);
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    RocketShip rocket=new RocketShip(250,700,50,50);
    GamePanel(){
    	
    	 Timer frameDraw = new Timer(1000/60,this);
    	    frameDraw.start();
    	
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
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);
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
	        currentState = MENU;
	    } else {
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
	    
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	

}



}
