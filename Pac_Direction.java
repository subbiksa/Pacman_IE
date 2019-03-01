/**
 * 
 */
package subbiksa;

/**
 * @author ssubb
 *
 */
public enum Pac_Direction{
	NORTH, EAST, SOUTH, WEST;
	
	/**
	* Turns 90 degrees left.
	*/
	// Can turn only 90 degrees
	public Pac_Direction turnLeft(){
		int index = ordinal()-1;
		if(index < 0){
			index = 3;
		}
		return values()[index];
	}
	
	public Pac_Direction turnRight(){
		int index = ordinal()+1;
		if(index > 3){
			index = 0;
		}
		return values()[index];
	}
}