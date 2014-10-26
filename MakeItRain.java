package MakeItRain;

import java.util.ArrayList;

import zen.core.Zen;

public class MakeItRain {
	

	public static void main(String[] args) {
		
		Zen.create(600,800);
		
		int score = 0;
		
		boolean gameOver = false;

		Player p = new Player();
		
		ArrayList<Coins> coinList = new ArrayList<Coins>();
		
		Coins c = new Coins();
		
		coinList.add(c);
		
		while(true) {
			
			if (gameOver) {
				
				//print game over screen
				Zen.setColor("black");
				Zen.drawText("GAME OVER", 200, 200);
				Zen.drawText("press space to play again!", 500, 500);
				
				if (Zen.isKeyPressed("space")) {
					gameOver = false;
					Zen.sleep(100);
				}
			}
			else {
				Zen.setBackground("orange");
				Zen.setColor("yellow");
				Zen.drawText("score: " + score, 50, 50);
				Zen.setColor("green");
				Zen.fillRect(0, 600, 600, 200);
			
				p.draw();
				p.move();
			
				if (coinList.get(coinList.size()-1).y > 40) {
					spawnCoin(coinList);
				}
			
				for (int i = 0; i < coinList.size(); i++ ) {
				
					coinList.get(i).draw();
					coinList.get(i).move();
				
				
					if (p.collects(coinList.get(i))) {
						score = score + coinList.get(i).value;
					
						coinList.remove(i);
					}
					if (coinList.get(i).y > 595) {
						coinList.remove(i);
						i--;
					}
				}
			
				Zen.buffer(30);
			}
		}
	}

	private static void spawnCoin(ArrayList<Coins> coinList) {
		
		int random = Zen.getRandomNumber(1, 10);
		
		if (random < 9) {
			Coins c = new Coins();
			coinList.add(c);
		}
		else {
			Brick b = new Brick();
			coinList.add(b);
		}
		
		
	}

}
