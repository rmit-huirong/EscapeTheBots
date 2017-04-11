/* Navod Bopitiya - s3617221 */

package etb.player;


import etb.user.User;

public class Player extends User{

	private int x;
	private int y;
	private int speed;
	private int score;
	
	private final int INITIAL_X_VALUE = 10;
	private final int INITIAL_Y_VALUE = 10;
	private final int DEFAULT_SPEED_VALUE = 1;

	public Player(String username, String password) {
		super(username, password);
		this.x = INITIAL_X_VALUE;
		this.y = INITIAL_Y_VALUE;
		this.score = 0;
		this.speed = DEFAULT_SPEED_VALUE;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean move(String direction){
		if(direction == "north"){
			setY(--y);
			return true;
		}else if(direction == "south"){
			setY(++y);
			return true;
		}else if(direction == "west"){
			setX(--x);
			return true;
		}else if(direction == "east"){
			setX(++x);
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean poisoned(Boolean poison){
		if(poison){
			this.speed =  this.speed / 2;
			return true;
		}else{
			return false;
		}
		
		
	}
	
}