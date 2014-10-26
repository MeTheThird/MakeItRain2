package MakeItRain;

import zen.core.Zen;

public class Player {
	
	int x;
	int y;
	int dy;
	boolean jumping = false;
	
	public Player() {
		
		x = 300;
		y = 590;
		dy = -1;
	}
	
	public void draw() {
	
		Zen.setColor("blue");
		Zen.fillRect(x - 25, y - 10, 50, 20);
	}

	public void move() {
		
		if (Zen.isKeyPressed("right")) {
			x = x + 5;
		}
		if (Zen.isKeyPressed("left")) {
			x = x - 5;
		}
		if (Zen.isKeyPressed("up") && jumping == false) {
			dy = -15;
			jumping = true;
		}
		if (y > 590) {
			y = 590;
			dy = 0;
			jumping = false;
		}
		else {
			y = y + dy;
			dy++;
		}
	}

	public boolean collects(Coins coins) {
		
		if (Math.abs(x - coins.x) < 30 && Math.abs(y - coins.y) < 15) {
			return true;
		}
		return false;
	}

}
