import java.util.*;


public class GameMechanics {
	
	private Random random = Utility.random;

	private final String theChallenge;
	private final int stringW, stringH;
	private final int speedFactor = 1;
	
	protected int x, y;
	protected double dx, dy;
	private final double angle;
	private final double speed;
	private int level;
	private final int W;
	private final int H;
	
	public GameMechanics(int level, int w, int h){
		if (level <= 0) throw new IllegalArgumentException();
		
		Zen.setFont("Helvetica-34");
		this.theChallenge = getChallenge();
		this.stringW = Zen.getBufferGraphics().getFontMetrics().stringWidth(theChallenge);
		this.stringH = Zen.getBufferGraphics().getFontMetrics().getHeight();
		
		this.W = w;
		this.H = h;
		this.level = level;
		
		this.x = random.nextInt(W - stringW);
		this.y = random.nextInt(H - 60) + stringH;
		
		this.speed = level * speedFactor;
		this.angle = random.nextDouble() * 2 * Math.PI;
		this.dx = Math.cos(angle) * speed;
		this.dy = Math.sin(angle) * speed;
	}
	
	public String getChallenge(){
		RandomStringGenerator gen = new RandomStringGenerator();
		if (level <= 10){ // the length of the Challenge is 3 and the Challenge only contains numbers
			return gen.get(3);
		} else if (level <= 20){ // the length of the Challenge is 3 and the Challenge contains only upper case letters
			gen.setConfig(EnumSet.of(RandomStringGenerator.Configurations.UPPER));
			return gen.get(3);
		} else if (level <= 30){ // the length of the Challenge is 4 and the Challenge only contains lower case letters
			gen.setConfig(EnumSet.of(RandomStringGenerator.Configurations.LOWER));
			return gen.get(4);
		} else if (level <= 40){ // the length of the Challenge is 4 and the Challenge contains mixed case letters
			gen.setConfig(EnumSet.of(RandomStringGenerator.Configurations.LOWER, RandomStringGenerator.Configurations.UPPER));
			return gen.get(4);
		} else if (level <= 50){ // the length of the Challenge is 5 and the Challenge contains alphanumeric strings that contains only upper case letter
			gen.setConfig(EnumSet.of(RandomStringGenerator.Configurations.UPPER, RandomStringGenerator.Configurations.NUMERIC));
			return gen.get(4);
		} else if (level <= 60){ // the length of the Challenge is 5 and the Challenge contains alphanumeric strings that contains only lower case letter
			gen.setConfig(EnumSet.of(RandomStringGenerator.Configurations.LOWER, RandomStringGenerator.Configurations.NUMERIC));
			return gen.get(5);
		} else{ // the length of the Challenge is 5 and the Challenge contains alphanumeric strings that contains mixed-case letter
			gen.setConfig(EnumSet.of(RandomStringGenerator.Configurations.UPPER, RandomStringGenerator.Configurations.NUMERIC, RandomStringGenerator.Configurations.LOWER));
			return gen.get((level - 1) / 10);
		}
	}
	
	private void update(){
		for (Margin margin : isOnMargin()){
			switch (margin){
			case UP:{
				dy = Math.abs(dy);
				break;
			}
			case DOWN:{
				dy = -Math.abs(dy);
				break;
			}
			case LEFT:{
				dx = Math.abs(dx);
				break;
			}
			case RIGHT:{
				dx = -Math.abs(dx);
				break;
			}
			}
		}
		// make the Challenge shaving during its movements -- feature removed
		x = (int) Math.round(x + dx + 0 * random.nextGaussian());
		y = (int) Math.round(y + dy + 0 * random.nextGaussian());
	}
	
	private enum Margin{UP, DOWN, LEFT, RIGHT, NONE}
	
	private Margin[] isOnMargin(){
		Margin[] margins = new Margin[]{Margin.NONE, Margin.NONE};
		//Left margin
		if (x <= 0) margins[0] = Margin.LEFT;
		if (x + stringW > W) margins[0] = Margin.RIGHT;
		if (y - stringH <= 0) margins[1] = Margin.UP;
		if (y > H) margins[1] = Margin.DOWN;
		return margins;
	}
	
	public int[] getPositionAndUpdate(){
		int[] ret = new int[]{x, y};
		update();
		return ret;
	}
}
