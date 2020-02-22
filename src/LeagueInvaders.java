import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	public static final int WIDTH=500;
	public static final int HIEGHT=800;
	
	 LeagueInvaders(){
		 panel= new GamePanel();
			frame=new JFrame();
	}	
public static void main(String[] args) {
	 LeagueInvaders un=new LeagueInvaders();
	un.setup();

	
}

void setup(){
	frame.setVisible(true);
	frame.add(panel);
	frame.setSize(WIDTH, HIEGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.addKeyListener(panel);
}


	
}
