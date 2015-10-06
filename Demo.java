//UIUC CS125 FALL 2014 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2015-09-28T21:47:28-0500.143780696

import java.util.*;

/**
 * @author replace-this-with-your-netids-on-this-line-here-with-a-comma-between-them
 */
public class Demo {
	
	private static final int upperMargin = 60;
	private static int score = 0, level = 1;
	private static GameMechanics game;
	private static String text;
	public static void reinitialize(){
		game = new GameMechanics(level, Zen.getZenWidth(), Zen.getZenHeight() - upperMargin);
		text = game.getChallenge();
		//text = "1234"; // demo
	}
	static{
		reinitialize();
	}
	
	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		//System.err.println(Zen.getZenHeight());
		
		long startTime =System.currentTimeMillis();
		
		
		Zen.setFont("Helvetica-34");
		while (Zen.isRunning()) {

			if (text.length() == 0) {
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				score += 1000000 / elapsed;
				level = score / 100 + 1;
				reinitialize();			
			}
			Zen.setColor(0, 0, 0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(255, 255, 255);
			Zen.drawText(text, game.getPositionAndUpdate()[0], game.getPositionAndUpdate()[1] + upperMargin);
			
			Zen.drawText(String.format("Level: %d", level),10,30);
			Zen.drawText(String.format("Score: %d", score),10,60);
			Zen.drawText(String.format("x: %d", game.x), 300, 30);
			Zen.drawText(String.format("y: %d", game.y), 300, 60);
//			Zen.drawText(String.format("dx: %f", demo.dx), 400, 30);
//			Zen.drawText(String.format("dy: %f", demo.dy), 400, 60);
			
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(text.length() != 0 && Character.toString(c).equalsIgnoreCase(text.substring(0, 1)))
					text = text.substring(1,text.length()); // all except first character
			}
			
			Zen.sleep(30);// sleep for 20 milliseconds

		}
	}

}

