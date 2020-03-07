import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Objectmanager implements ActionListener{

	RocketShip big;
	Random randy;
	
	
	
	Objectmanager(RocketShip x){
		big=x;
		randy=new Random();
	}
	ArrayList<Alien> aliens=new ArrayList<Alien>();
	ArrayList<Projectile> projectiles=new ArrayList<Projectile>();
	
	void addProjectile(Projectile pont) {
		
		projectiles.add(pont);
		
	}
	
	void addAlien() {
		
		aliens.add(new Alien(randy.nextInt(LeagueInvaders.WIDTH),0,50,50));
		
		
	}
	
	void update() {
		
for (int i = 0; i < aliens.size(); i++) {
		
		aliens.get(i).update();
		if(aliens.get(i).y>LeagueInvaders.HIEGHT) {
		aliens.get(i).isactive=false;	
		}
		}

for (int i = 0; i < projectiles.size(); i++) {
	projectiles.get(i).update();
	if(projectiles.get(i).y<0) {
		projectiles.get(i).isactive=false;	
		}
}

	}
	void draw(Graphics b) {
		
		big.draw(b);
		
		for(int i = 0; i < aliens.size(); i++) {
			
			aliens.get(i).draw(b);
			
		}
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			

			if(aliens.get(i).isactive==false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			
			if(projectiles.get(i).isactive==false) {
				
				}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
}
	
	
