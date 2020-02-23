
public class GameObject {
	 int x;
	 int y;
	 int width;
	 int height;
	 int speed;
	 boolean isactive=true;
	GameObject(int x,int y,int width,int height){
		
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		speed=20;
	}
	
	
	void update() {
	
	}
	
	 public void right() {
	     if(x<500) { 
		 x+=speed;
	     }
	    }
	 public void left() {
	        
		 if(x>0) {
			 x-=speed;
		 }
	    }
	 public void up() {
		 if(y>0) {
			 y-=speed;
		 }
	    }
	 public void down() {

		 if(y<800) { 
			 y+=speed;
		     }
	    }
}
