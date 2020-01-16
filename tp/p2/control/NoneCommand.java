package tp.p2.control;

import tp.p2.logic.Game;

public class NoneCommand extends Command {

	public NoneCommand() {
		super("None", "", "[None]", "Skips one cycle.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].contentEquals(""))
			return (new NoneCommand());
		return null;
	}

}
