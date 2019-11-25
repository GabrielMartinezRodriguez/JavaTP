package tp.p1.control;

import tp.p1.logic.Game;

public class ExitCommand extends Command {

	public ExitCommand() {
		super("exit", "e", "exit" , "Terminates the program.");
	}

	@Override
	public boolean execute(Game game) {
		game.c_exit();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].contentEquals("e") || commandWords[0].contentEquals("exit"))
			return (new ExitCommand());
		return null;
	}
}
