package tp.p1.control;

import tp.p1.logic.Game;

public class MoveCommand extends Command {

	public MoveCommand() {
		super("move", "m", "move <left|right><1|2>", "Moves UCM-Ship to the indicated direction.");
		// TODO Auto-generated constructor stub
	}
	public MoveCommand(String name) {
		super(name, "m", "move <left|right><1|2>", "Moves UCM-Ship to the indicated direction.");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean execute(Game game) {
		if(name.contentEquals("left 1"))
			game.move(-1);
		else if(name.contentEquals("left 2"))
			game.move(-2);
		else if(name.contentEquals("right 1"))
			game.move(1);
		else if(name.contentEquals("right 2"))
			game.move(2);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if((commandWords[0].contentEquals("m") || commandWords[0].contentEquals("move")) && commandWords.length == 3)
		{
			if(commandWords[0].contentEquals("m") || commandWords[0].contentEquals("move"))
			{
				if(commandWords[1].contentEquals("left") || commandWords[1].contentEquals("right"))
				{
					if(commandWords[2].contentEquals("1") || commandWords[2].contentEquals("2"))
						return(new MoveCommand(commandWords[1] + " " + commandWords[2]));
				}
			}
		}
		return null;
	}

}
