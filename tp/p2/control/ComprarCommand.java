package tp.p2.control;

import tp.p2.logic.CommandExecuteException;
import tp.p2.logic.Game;
import tp.p2.logic.objects.SuperMisil;

public class ComprarCommand extends Command {

	public ComprarCommand() {
		super("comprar", "c", "comprar", "Puedes comprar items con tus puntos");
		// TODO Auto-generated constructor stub
	}
	public ComprarCommand(String Name) {
		super(Name, "c", "comprar", "Puedes comprar items con tus puntos");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(game.getPoints() >= SuperMisil.getCoste())
		{
			game.buySuperMisile();
			return false;
		}
		else
			throw new CommandExecuteException("No tienes suficientes puntos para comprar un supermisil");
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].contentEquals("c") || commandWords[0].contentEquals("comprar") && commandWords.length > 1)
		{
			if(commandWords[1].contentEquals("supermisil"))
				return(new ComprarCommand("SuperMisil"));
		}
		return null;
	}

}
