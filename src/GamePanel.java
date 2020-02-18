import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    int currentState = MENU;
    
    void updateMenuState() {
    	
    }
    void updateGameState() { 
    	
    }
    void updateEndState()  {
    	
    }
    
    
    void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);
    }
    void drawGameState(Graphics g) { 
    	
    }
    void drawEndState(Graphics g)  { 
    	
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
}