package tp.p1.control;

import tp.p1.logic.Game;

public class ShootCommand extends Command {

	public ShootCommand() {
		super("shoot", "s", "shoot", "UCM-Ship launches a missile.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.c_Shoot();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].contentEquals("s") || commandWords[0].contentEquals("shoot"))
			return (new ShootCommand());
		return null;
	}

}
