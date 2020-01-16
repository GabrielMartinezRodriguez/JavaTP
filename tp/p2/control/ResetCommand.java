package tp.p2.control;

import tp.p2.logic.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("reset", "r", "reset", "Starts a new game.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].contentEquals("reset") || commandWords[0].contentEquals("r"))
			return (new ResetCommand());
		return null;
	}

}
