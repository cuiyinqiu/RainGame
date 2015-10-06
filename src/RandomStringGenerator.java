package src;
import java.util.*;


public class RandomStringGenerator {
	
	private static Random random = Utility.random;
	private static String collection = "0123456789abcdefghijklmnopqrstuvwxyz";
	private EnumSet<Configurations> config;
	
	public static char getAlphanumeric(){
		char c = collection.charAt(random.nextInt(36)) ;
		return c ;
	}
	
	public static char getNumberic(){
		char c = collection.charAt(random.nextInt(10)) ;
		return c ;
	}
	
	public static char getAlphabetic(){
		char c = collection.charAt(random.nextInt(26) + 10) ;
		return c ;
	}
	
	public enum Configurations implements Utility.Weighted{
		
		NUMERIC(10, '0'), UPPER(26, 'A'), LOWER(26, 'a');
		
		private final int charNum;
		private final char start;
		
		private Configurations(int charNum, char start){
			this.charNum = charNum;
			this.start = start;
		}

		@Override
		public double getWeight() {
			return charNum;
		}
	}
	
	public RandomStringGenerator(EnumSet<Configurations> config){
		this.config = config;
	}
	
	public RandomStringGenerator(){
		this(EnumSet.of(Configurations.NUMERIC));
	}
	
	public char getChar(){
		Configurations selected = Utility.weightedRandomSelect(config);
		return (char) (selected.start + random.nextInt(selected.charNum));
	}
	
	public void setConfig(EnumSet<Configurations> c){
		config = c;
	}
	
	public String get(int length){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++){
			builder.append(getChar());
		}
		return builder.toString();
	}
}


