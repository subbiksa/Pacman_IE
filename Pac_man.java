/**
 * 
 */
package subbiksa;

/**
 * @author ssubb
 *
 */
//Direction of the Pacman defined based on co-ordinates
public class Pac_man{
	private int x, y;
	private Pac_Direction direction;
	
	private Pac_man(int x, int y, Pac_Direction direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public static Pac_man create(Place_Command placeCommand){
		int x = placeCommand.getX();
		int y = placeCommand.getY();
		if(x >= Pac_Application.x_low && x <= Pac_Application.x_high && y >= Pac_Application.y_low && y <= Pac_Application.y_high){
			return new Pac_man(x, y, placeCommand.getDirection());
		} else{
			return null;
		}
	}
	
	/**
	 * Places Pacman based on the given PlaceCommand.
	 * @param placeCommand the command for where to place pacman
	 * @return True if the PlaceCommand was valid and pacman was placed, otherwise False.
	 */
	public boolean place(Place_Command placeCommand){
		int x = placeCommand.getX();
		int y = placeCommand.getY();
		if(x >= Pac_Application.x_low && x <= Pac_Application.x_high && y >= Pac_Application.y_low && y <= Pac_Application.y_high){
			this.x = x;
			this.y = y;
			this.direction = placeCommand.getDirection();
			return true;
		} else{
			return false;
		}
	}
	
	public void turnLeft(){
		this.direction = this.direction.turnLeft();
	}
	
	public void turnRight(){
		this.direction = this.direction.turnRight();
	}
	
	public boolean move(){
		boolean valid = false;
		switch(direction){
			case NORTH:
			{
				if(this.y < Pac_Application.y_high){
					++this.y;
					valid = true;
				}
			} break;
			case EAST:
			{
				if(this.x < Pac_Application.x_high){
					++this.x;
					valid = true;
				}
			} break;
			case SOUTH:
			{
				if(this.y > Pac_Application.y_low){
					--this.y;
					valid = true;
				}
			} break;
			case WEST:
			{
				if(this.x > Pac_Application.x_low){
					--this.x;
					valid = true;
				}
			} break;
		}
		return valid;
	}
	
	public void REPORT(){
		System.out.println( getReportString() );
	}
	
	public String getReportString(){
		return String.format("x:%d, y:%d, facing:%s", x, y, getDirectionString());
	}
	
	public boolean handle(Pac_Instruction ins){
		boolean valid = false;
		if(ins instanceof Place_Command){
			valid = place( (Place_Command)ins);
		} else {
			switch(ins.getType()){
				case MOVE:
				{
					valid = move();
				} break;
				case RIGHT:
				{
					turnRight();
					valid = true;
				} break;
				case LEFT:
				{
					turnLeft();
					valid = true;
				} break;
				case REPORT:
				{
					REPORT();
					valid = true;
				} break;
				case INVALID:
				{
					valid = false;
				} break;
			case EXIT:
				break;
			case PLACE:
				break;
			default:
				break;
			}
		}
		return valid;
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
	
	public String getDirectionString(){
		String answer = null;
		switch(direction){
			case NORTH:
			{
				answer = "north";
			} break;
			case EAST:
			{
				answer = "east";
			} break;
			case SOUTH:
			{
				answer = "south";
			} break;
			case WEST:
			{
				answer = "west";
			} break;
		}
		return answer;
	}

	public static Pac_man create(Pac_Instruction ins) {
		// TODO Auto-generated method stub
		return null;
	}
}

