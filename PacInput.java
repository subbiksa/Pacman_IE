package subbiksa;

import java.util.Scanner;

/**
* Handles getting and interpreting input from the user.
*/
//Gets the command that are pre-defined in the enum
public class PacInput{
	private Scanner in;
	
	public PacInput(){
		this.in = new Scanner(System.in);
	}
	
	public Pac_Instruction getNext(){
		System.out.print("Next command: ");
		System.out.flush();
		String line = in.nextLine();
		System.out.println("OH! Hello There:) Pacman Says Welcome");
		return interpretCommand(line);
	}
	
	/**
	* Takes a line, and turns it into a Command object.
	* @return the relevant Command.
	*/
	public Pac_Instruction interpretCommand(String line){
		Pac_Instruction command = null;
		String[] lineSpaceSplit = line.trim().split(" ");
		if(lineSpaceSplit.length == 0){
			command = new Pac_Instruction(Pac_Instruction.type.INVALID);
		}
		else if(lineSpaceSplit.length == 1){
			// MOVE, LEFT, RIGHT, REPORT, EXIT, or INVALID
			command = interpretOne(lineSpaceSplit[0]);
		} else{
			// PLACE or INVALID
			command = interpretMulti(lineSpaceSplit);
		}
		return command;
	}
	
	public Pac_Instruction interpretOne(String commandString){
		Pac_Instruction command = null;
		switch(commandString.toLowerCase()){
			case "move":
			{
				command = new Pac_Instruction(Pac_Instruction.type.MOVE);
			} break;
			case "left":
			{
				command = new Pac_Instruction(Pac_Instruction.type.LEFT);
			} break;
			case "right":
			{
				command = new Pac_Instruction(Pac_Instruction.type.RIGHT);
			} break;
			case "REPORT":
			{
				command = new Pac_Instruction(Pac_Instruction.type.REPORT);
			} break;
			case "exit":
			{
				command = new Pac_Instruction(Pac_Instruction.type.EXIT);
			} break;
			default:
			{
				command = new Pac_Instruction(Pac_Instruction.type.INVALID);
			} break;
		}
		return command;
	}
	
	public Pac_Instruction interpretMulti(String[] lineSpaceSplit){
		Pac_Instruction command = null;
		if(lineSpaceSplit[0].toLowerCase().equals("place")){
			// PLACE
			command = interpretPlaceCommand(lineSpaceSplit);
		} else{
			// INVALID
			command = new Pac_Instruction(Pac_Instruction.type.INVALID);
		}
		return command;
	}
	
	public Pac_Instruction interpretPlaceCommand(String[] lineSpaceSplit){
		Pac_Instruction command = null;
		StringBuilder xyf = new StringBuilder();
		for(int i = 1; i < lineSpaceSplit.length; ++i){
			xyf.append(lineSpaceSplit[i]);
		}
		String[] xyfCommaSplit = xyf.toString().split(",");
		
		if(xyfCommaSplit.length == 3){
			// has 3 arguments
			int x;
			int y;
			try{
				x = Integer.parseInt(xyfCommaSplit[0]);
				y = Integer.parseInt(xyfCommaSplit[1]);
				String f = xyfCommaSplit[2];
				switch(f.toLowerCase()){
					case "north":
					{
						command = new Place_Command(x, y,Pac_Direction.NORTH);
					} break;
					case "east":
					{
						command = new Place_Command(x, y, Pac_Direction.EAST);
					} break;
					case "south":
					{
						command = new Place_Command(x, y,Pac_Direction.SOUTH);
					} break;
					case "west":
					{
						command = new Place_Command(x, y, Pac_Direction.WEST);
					} break;
					default:
					{
						command = new Pac_Instruction(Pac_Instruction.type.INVALID);
					} break;
				}
			} catch(NumberFormatException e){
				// one of the numbers is an invalid format
				command = new Pac_Instruction(Pac_Instruction.type.INVALID);
			}
		} else{
			// doesnt have 3 arguments
			command = new Pac_Instruction(Pac_Instruction.type.INVALID);
		}
		return command;
	}
	
}