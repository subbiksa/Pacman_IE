/**
 * 
 */
package subbiksa;

/**
 * @author ssubb
 *
 */
//The overall structure of the Pacman App with a grid dimension of 5*5
public class Pac_Application {
			 public static final int x_low = 0;
			 public static final int x_high =4;
			 public static final int y_low = 0;
			 public static final int y_high =4;
			 public static final String PLACE = "PLACE x,y,f: x,y co-ordinates in 5*5 dimensions  f(direction) = NORTH, SOUTH, EAST, or WEST";
			 public static final String VALID = "The Accepted Commands: | PLACE x,y,f | MOVE | LEFT | RIGHT | REPORT | EXIT |";
			 public boolean exec;
			 public PacInput input;
			 public Pac_man pacman;
			 
			 public Pac_Application() {
				 this.exec= false;
				 this.input= new PacInput();
				 this.pacman=null;
			 }
			 public void exec() {
				 this.exec=true;
				 System.out.println("OH! Hello There:) Pacman Says Welcome"+PLACE);
				 while(pacman == null && exec){
						System.out.println();
						Pac_Instruction ins = input.getNext();
						if(ins instanceof Pac_Instruction){
							pacman = Pac_man.create( (Pac_Instruction)ins );
						} else if(ins.getType() == Pac_Instruction.type.EXIT){
							close();
						}
					
						if(pacman == null && exec){
							System.out.println("INPUT INVALID: Ensure valid format.\n"+PLACE);
						}
					
					
					// Job done
					if(exec){
						System.out.println("Pacman successfully placed");
						pacman.success();
					}
					
					// while the thread executes
					while(exec){
						System.out.println(VALID);
						Pac_Instruction ins = input.getNext();
						if(ins.getType() == Pac_Instruction.type.EXIT){
							close();
						} else {
							boolean valid = pacman.handle(ins);
							if(valid){
								System.out.println("Ready to go-Pacman");
							} else {
								System.out.println("Oops, Invalid Instruction, Please Try Again");
							}
						}
					}
				}
				
				public void close(){
					System.out.println("See ya later:-Love-pacman");
					this.exec = false;
				}
			}