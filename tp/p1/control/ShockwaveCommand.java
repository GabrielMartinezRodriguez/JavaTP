package tp.p1.control;

import tp.p1.logic.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand() {
		super("shockwave", "s", "shockWave", "UCM-Ship releases a shock wave.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.c_ShockWave();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].contentEquals("w") || commandWords[0].contentEquals("shockwave"))
			return (new ShockwaveCommand());
		return null;
	}

}
