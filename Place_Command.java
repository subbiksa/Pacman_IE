/**
 * 
 */
package subbiksa;

/**
 * @author ssubb
 *
 *Gets the parameter to place according to x, y and f
 */
public class Place_Command extends Pac_Instruction {
	public static final String Type = null;
	private int x;
	private int y;
	private Pac_Direction direction;
	
	public Place_Command(int x, int y, Pac_Direction direction){
		super(type.PLACE);
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Pac_Direction getDirection(){
		return direction;
	}
}