package tp.p1.control;

import tp.p1.logic.CommandExecuteException;
import tp.p1.logic.Game;

public class ShootCommand extends Command {

	public ShootCommand() {
		super("shoot", "s", "shoot", "UCM-Ship launches a missile.");
		// TODO Auto-generated constructor stub
	}
	public ShootCommand(String Name) {
		super(Name, "s", "shoot", "UCM-Ship launches a missile.");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(name.contentEquals("misil"))
			game.shootMissile();
		else if(name.contentEquals("supermisil"))
			game.shootSuperMissile();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].contentEquals("s") || commandWords[0].contentEquals("shoot"))
		{
			if(commandWords.length > 1 && commandWords[1].contentEquals("supermisil"))
				return (new ShootCommand("supermisil"));
			else
				return (new ShootCommand("misil"));
		}
		return null;
	}

}
