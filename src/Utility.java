package src;
import java.awt.*;
import javax.swing.*;


import java.util.Random;


public class Utility {
	
	public static final Random random = new Random();
	
	public static int floorDiv(int a, int b){
		return (int) Math.floor(((double)a) / b);
	}
	
	public static int floorMod(int a, int b){
		return a - b * floorDiv(a, b);
	}
	
	public static interface Weighted{
		
		public double getWeight();
	}
	
	public static <T extends Weighted> T weightedRandomSelect(Iterable<T> collection){
		double weight = 0;
		double prob = random.nextDouble(), cumulative = 0.0;
		for(T c : collection){
			weight += c.getWeight();
		}
		T temp = null;
		for(T c : collection){
			temp = c;
			cumulative += c.getWeight() / weight;
			if (cumulative >= prob){
				return c;
			}
		}
		return temp;
	}

}
