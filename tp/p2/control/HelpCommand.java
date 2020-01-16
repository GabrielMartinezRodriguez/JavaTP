package tp.p2.control;

import tp.p2.logic.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "h", "help", "Prints this help message.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		System.out.print(CommandGenerator.commandHelp());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		if(commandWords[0].contentEquals("h") || commandWords[0].contentEquals("help"))
			return(new HelpCommand());
		return null;
	}

}
