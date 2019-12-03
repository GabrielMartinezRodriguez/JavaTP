package tp.p1.control;

import tp.p1.logic.Game;

public class ListCommand extends Command {

	public ListCommand() {
		super("List Command", "List", "list", "Prints the list of available ships.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.list();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].contentEquals("l") || commandWords[0].contentEquals("list"))
			return(new ListCommand());
		return null;
	}

}
