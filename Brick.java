package MakeItRain;

import zen.core.Zen;

public class Brick extends Coins {
	
	public Brick() {
		
		x = Zen.getRandomNumber(5, 595);
		y = 10;
		speed = 7;
		value = 0;
		isBrick = true;
	}
	
	public void draw() {
		
		Zen.setColor("red");
		Zen.fillRect(x, y, 30, 20);
	}
}
