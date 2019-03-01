/**
 * 
 */
package subbiksa;

/**
 * @author ssubb
 *
 */
//enum is defined for the pre given commands
public class Pac_Instruction {
	public enum type{ PLACE, LEFT, RIGHT, EXIT, INVALID, MOVE, REPORT}
	//the type enum created for all the parameters used
	//public static Object Type;

	private type type;
	
	public Pac_Instruction (type type) {
		// constructor
		this.type=type;
		
	}
	public type getType() {
		return type;
	}
	
}
